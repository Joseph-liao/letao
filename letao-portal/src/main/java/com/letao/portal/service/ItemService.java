/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.service
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
 *    Create at:   2017年5月10日 下午2:48:08
 *
 *    Revision:
 *
 *    2017年5月10日 下午2:48:08
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.service;

import com.letao.portal.pojo.ItemInfo;

/**
 * @ClassName ItemService
 * @Description TODO(展示商品详情service)
 * @author 廖永乐
 * @Date 2017年5月10日 下午2:48:08
 * @version 1.0.0
 */
public interface ItemService {

    /**
     * 
     * @Description (根据Id展示商品基本信息)
     * @param itemId
     * @return
     */
    public ItemInfo getItemById(Long itemId);
    
    /**
     * 
     * @Description (根据商品id查找商品描述)
     * @param itemId
     * @return
     */
    public String getItemDescById(Long itemId);
    
    /**
     * 
     * @Description (根据商品id查找商品规格参数)
     * @param itemId
     * @return
     */
    public String getItemParam(Long itemId);
}
