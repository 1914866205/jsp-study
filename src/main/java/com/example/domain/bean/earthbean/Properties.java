/**
  * Copyright 2022 bejson.com 
  */
package com.example.domain.bean.earthbean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Auto-generated: 2022-05-05 21:51:40
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Properties {

    private Double mag;
    private String place;

    @JSONField(format="yyyy-MM")
    private Date time;
    @JSONField(format="yyyy-MM")
    private Date updated;
    private String tz;
    private String url;
    private String detail;
    private String felt;
    private String cdi;
    private double mmi;
    private String alert;
    private String status;
    private int tsunami;
    private int sig;
    private String net;
    private String code;
    private String ids;
    private String sources;
    private String types;
    private String nst;
    private double dmin;
    private double rms;
    private int gap;
    private String magType;
    private String type;
    private String title;

}