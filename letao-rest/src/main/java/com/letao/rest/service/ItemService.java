/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service
 *
 *    Filename:    ItemService.java
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
 *    Create at:   2017年5月9日 下午4:13:17
 *
 *    Revision:
 *
 *    2017年5月9日 下午4:13:17
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service;

import com.letao.common.pojo.LetaoResult;

/**
 * @ClassName ItemService
 * @Description TODO(商品信息service)
 * @author 廖永乐
 * @Date 2017年5月9日 下午4:13:17
 * @version 1.0.0
 */
public interface ItemService {
    
    /**
     * 
     * @Description (得到相片基本信息)
     * @param itemId
     * @return
     */
    public LetaoResult getItemBaseInfo(long itemId); 
    
    /**
     * 
     * @Description (得到商品描述)
     * @param itemId
     * @return
     */
    public LetaoResult getItemDesc(long itemId);
    
    /**
     * 
     * @Description (得到商品规格信息)
     * @param itemId
     * @return
     */
    public LetaoResult getItemParam(long itemId);

}
