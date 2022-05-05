/**
  * Copyright 2022 bejson.com 
  */
package com.example.domain.bean.earthbean;
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
public class Metadata {
    private long generated;
    private String url;
    private String title;
    private int status;
    private String api;
    private int limit;
    private int offset;
    private int count;


}