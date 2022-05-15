<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- 引入EasyUI的CSS和JS -->
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../demo.css">
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        function newGood() {
            $('#dlg').dialog('open').dialog('setTitle', '创建商品');
            $('#fm').form('clear');
            url = '/easy-ui/servlet/good/create';
        }

        function editGood() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $('#dlg').dialog('open').dialog('setTitle', '编辑商品');
                $('#fm').form('load', row);
                url = 'servlet/good/Update?id=' + row.id;
            }
        }
        function selectGood() {
            $('#dg').datagrid('load',{
                searchInfo: $('#searchInfo').val()
            });
        }

        function saveGood() {
            $('#fm').form('submit', {
                url: url,
                onSubmit: function () {
                    return $(this).form('validate');
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.errorMsg) {
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');		// close the dialog
                        $('#dg').datagrid('reload');	// reload the user data
                    }
                }
            });
        }

        function destroyGood() {
            var row = $('#dg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('确定？', '确实删除吗?', function (r) {
                    if (r) {
                        $.post('servlet/good/Del', {id: row.id}, function (result) {
                            if (result.success) {
                                $('#dg').datagrid('reload');
                            } else {
                                $.messager.show({	// show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        }, 'json');
                    }
                });
            }
        }
        function getData(){
            var rows = [];
            for(var i=1; i<=800; i++){
                var amount = Math.floor(Math.random()*1000);
                var price = Math.floor(Math.random()*1000);
                rows.push({
                    inv: 'Inv No '+i,
                    date: $.fn.datebox.defaults.formatter(new Date()),
                    name: 'Name '+i,
                    amount: amount,
                    price: price,
                    cost: amount*price,
                    note: 'Note '+i
                });
            }
            return rows;
        }

        function pagerFilter(data){
            if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
                data = {
                    total: data.length,
                    rows: data
                }
            }
            var dg = $(this);
            var opts = dg.datagrid('options');
            var pager = dg.datagrid('getPager');
            pager.pagination({
                onSelectPage:function(pageNum, pageSize){
                    opts.pageNumber = pageNum;
                    opts.pageSize = pageSize;
                    pager.pagination('refresh',{
                        pageNumber:pageNum,
                        pageSize:pageSize
                    });
                    dg.datagrid('loadData',data);
                }
            });
            if (!data.originalRows){
                data.originalRows = (data.rows);
            }
            var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
            var end = start + parseInt(opts.pageSize);
            data.rows = (data.originalRows.slice(start, end));
            return data;
        }

        $(function(){
            $('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
        });
    </script>
</head>
<body>
<div style="margin:20px 0;"></div>
<div class="easyui-layout" style="width:700px;height:400px;">
    <div data-options="region:'north'" title="商品管理系统" style="height:60px">
        <button><span>你好<%=session.getAttribute("username")%></span></button>
    </div>
    <div data-options="region:'west',split:true" title="系统菜单" style="width:100px;">
        <a href="/easy-ui/servlet/good/Logout" class="easyui-linkbutton" iconCls="icon-remove" plain="true">退出</a>
    </div>
    <div data-options="region:'center',title:'数据区域',iconCls:'icon-ok'">
        <table id="dg" title="商品列表" class="easyui-datagrid" style="width:600px;height:300px"
               url="servlet/good/Load"
               toolbar="#toolbar" pafomain="true" idField="id" striped="true" pagination="true"
               rownumbers="true" fitColumns="true" singleSelect="true" autoRowHeight="false" pageSize="10">
            <thead>
            <!--  striped="true"   设置为 true，则把行条纹化。（即奇偶行使用不同背景色） -->
            <!--  idField="id"   指示哪个字段是标识字段。 -->
            <!--  idField="id"   指示哪个字段是标识字段。 -->
            <!--  pagination	boolean	设置为 true，则在数据网格（datagrid）底部显示分页工具栏。 -->
            <!--  rownumbers	boolean	设置为 true，则显示带有行号的列。 -->
            <!--  fitColumns	boolean	设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。 -->
            <!--  toolbar	数据网格（datagrid）面板的头部工具栏。 -->
            <!--  url	string	从远程站点请求数据的 URL。 -->
            <!-- singleSelect	boolean	设置为 true，则只允许选中一行。 -->
            <tr>
                <th field="id" width="50">商品id</th>
                <th field="name" width="50">商品名称</th>
                <th field="price" width="50">价格</th>
            </tr>
            </thead>
        </table>
        <div id="toolbar">
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newGood()">添加</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editGood()">修改</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyGood()">删除</a>
            <input id="searchInfo" style="line-height:26px;border:1px solid #ccc">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="selectGood()">查询</a>
        </div>
    </div>
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
         closed="true" buttons="#dlg-buttons">
        <div class="ftitle">商品信息</div>
        <form id="fm" method="post">
            <div class="fitem">
                <label>商品名称:</label>
                <input name="name" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>价格:</label>
                <input name="price" class="easyui-validatebox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveGood()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel"
           onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>
</div>
</body>
</html>


