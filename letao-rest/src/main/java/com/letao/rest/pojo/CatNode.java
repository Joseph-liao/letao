/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.pojo
 *
 *    Filename:    CatNode.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     廖永乐
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017年4月8日 上午10:23:27
 *
 *    Revision:
 *
 *    2017年4月8日 上午10:23:27
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ClassName CatNode
 * @Description TODO(对应Json的商品目录节点)
 * @author 廖永乐
 * @Date 2017年4月8日 上午10:23:27
 * @version 1.0.0
 */
public class CatNode {

    @JsonProperty("n")
    private String name;
    
    @JsonProperty("u")
    private String url;
    
    @JsonProperty("i")
    private List<?> item;

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    
    /**
     * @return the item
     */
    public List<?> getItem() {
        return item;
    }

    
    /**
     * @param item the item to set
     */
    public void setItem(List<?> item) {
        this.item = item;
    }
    
    
}
