/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service
 *
 *    Filename:    ItemCatService.java
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
 *    Create at:   2017年4月8日 上午10:30:36
 *
 *    Revision:
 *
 *    2017年4月8日 上午10:30:36
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service;

import com.letao.rest.pojo.CatResult;

/**
 * @ClassName ItemCatService
 * @Description TODO(商品目录service)
 * @author 廖永乐
 * @Date 2017年4月8日 上午10:30:36
 * @version 1.0.0
 */
public interface ItemCatService {

    /**
     * 
     * @Description (查询商品目录结果集)
     * @return
     */
    public CatResult getCatResult();
}
