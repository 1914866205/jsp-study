package com.example.reflex;

import com.example.domain.bean.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName main
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/4/27 13:35
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        /**
         * 反射：获取Class对象的四种方式
         */
        // 1、在知道具体类的情况下使用
        Class<Student> student1 = com.example.domain.bean.Student.class;
        System.out.println("student1:"+student1);
        // 2、通过Class.forName()传入类的全路径获取
        Class<?> student2 = Class.forName("com.example.domain.bean.Student");
        System.out.println("student2:"+student2);
        // 3、通过对象实例 instance.getClass()获取
        Student Student = new Student();
        Class student3 = Student.getClass();
        System.out.println("student3:"+student3);
        // 4、通过类加载器 xxxClassLoader.loadClass()传入类路径获取
//        Class student4 = ClassLoader.loadClass("com.example.domain.bean.Student");


        /**
         * 使用反射操作一个类的方法及参数
         */
        Student ntt = (com.example.domain.bean.Student) student2.newInstance();
        System.out.println("ntt:"+ntt);
        /**
         * 获取Student类中定义的所有方法
         */
        System.out.println("==========获取Student类中定义的所有方法==========");
        Method[] methods = student2.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("==========获取Student类中定义的所有方法==========");
        /**
         * 获取方法并调用
         */
        System.out.println(ntt);
        Method setName= student2.getDeclaredMethod("setName", String.class);
        setName.invoke(ntt, "倪涛涛");
        System.out.println(ntt);
        /**
         * 获取指定参数并对参数进行修改
         */
        Field name = student2.getDeclaredField("name");
        //私有方法，需要对类中的参数取消安全检查
        name.setAccessible(true);
        name.set(ntt, "涛涛涛涛");
        System.out.println(ntt);

        /**
         * 调用private方法
         */
        Method getMyName = student2.getDeclaredMethod("getMyName");
        getMyName.setAccessible(true);
        System.out.println("==========调用private方法==========");
        System.out.println(getMyName.invoke(ntt));
        System.out.println("==========调用private方法==========");
    }
}
