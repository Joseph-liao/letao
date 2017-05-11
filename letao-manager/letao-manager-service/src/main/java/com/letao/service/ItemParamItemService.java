/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    ItemParamItemService.java
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
 *    Create at:   2017年4月1日 上午10:58:49
 *
 *    Revision:
 *
 *    2017年4月1日 上午10:58:49
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import com.letao.common.pojo.LetaoResult;

/**
 * @ClassName ItemParamItemService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月1日 上午10:58:49
 * @version 1.0.0
 */
public interface ItemParamItemService {

    /**
     * 
     * @Description (根据商品ID得到其规格参数)
     * @param itemId
     * @return
     */
    public String getItemParamByItemId(Long itemId);
    
    /**
     * 
     * @Description (根据商品ID得到其规格参数,返回自定义结果对象)
     * @param itemId
     * @return
     */
    public LetaoResult queryItemParamByItemId(Long itemId);
    
/*    *//**
     * 
     * @Description (根据商品类目ID删除商品规格参数)
     * @param cId
     * @return
     *//*
    public int deleteItemParamItemById(Long cId);
    
    *//**
     * 
     * @Description (批量删除商品规格属性)
     * @param cIds
     * @return
     *//*
    public LetaoResult deleteItemParams(Long[] cIds);*/
}
