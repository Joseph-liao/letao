/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.common.pojo
 *
 *    Filename:    EUTreeNode.java
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
 *    Create at:   2017年3月27日 下午3:07:39
 *
 *    Revision:
 *
 *    2017年3月27日 下午3:07:39
 *        - first revision
 *
 *****************************************************************/
package com.letao.common.pojo;


/**
 * @ClassName EUTreeNode
 * @Description TODO(EasyUI树节点结构)
 * @author 廖永乐
 * @Date 2017年3月27日 下午3:07:39
 * @version 1.0.0
 */
public class EUTreeNode {

    private long id;
    private String text;
    private String state;
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
    
    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    
    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
}
