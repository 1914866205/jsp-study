/**
  * Copyright 2022 bejson.com 
  */
package com.example.domain.bean.earthbean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Features {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private String id;

}