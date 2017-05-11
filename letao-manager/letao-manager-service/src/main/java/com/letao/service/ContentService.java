/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    ContentService.java
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
 *    Create at:   2017年4月10日 下午8:05:34
 *
 *    Revision:
 *
 *    2017年4月10日 下午8:05:34
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbContent;

/**
 * @ClassName ContentService
 * @Description TODO(广告内容service)
 * @author 廖永乐
 * @Date 2017年4月10日 下午8:05:34
 * @version 1.0.0
 */
public interface ContentService {

    /**
     * 
     * @Description (得到EasyUI列表的商品内容list)
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    public EUDataGridResult getContentListByCategoryId(int page,int rows,long categoryId);
    
    /**
     * 
     * @Description (添加新的商品内容)
     * @param content
     * @return
     */
    public LetaoResult insertContent(TbContent content);
    
    /**
     * 
     * @Description (根据商品广告id批量删除)
     * @param ids
     * @return
     */
    public LetaoResult deleteConetnts(Long[] ids);
}
