/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service
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
 *    Create at:   2017年4月13日 下午9:10:04
 *
 *    Revision:
 *
 *    2017年4月13日 下午9:10:04
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service;

import java.util.List;

import com.letao.pojo.TbContent;

/**
 * @ClassName ContentService
 * @Description TODO(商品内容service)
 * @author 廖永乐
 * @Date 2017年4月13日 下午9:10:04
 * @version 1.0.0
 */
public interface ContentService {
    
    /**
     * 
     * @Description (根据内容类目id查询商品内容集)
     * @param contentCid
     * @return
     */
    public List<TbContent> getContentList(long contentCid);

}
