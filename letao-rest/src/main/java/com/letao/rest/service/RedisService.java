/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service
 *
 *    Filename:    RedisService.java
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
 *    Create at:   2017年4月25日 下午10:23:52
 *
 *    Revision:
 *
 *    2017年4月25日 下午10:23:52
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service;

import com.letao.common.pojo.LetaoResult;

/**
 * @ClassName RedisService
 * @Description TODO(缓存同步服务)
 * @author 廖永乐
 * @Date 2017年4月25日 下午10:23:52
 * @version 1.0.0
 */
public interface RedisService {

    /**
     * 
     * @Description (根据类目id删除缓存)
     * @param contentCid
     * @return
     */
    public LetaoResult syncContent(long contentCid);
    
    /**
     * 
     * @Description (删除商品目录 缓存)
     * @return
     */
    public LetaoResult sycnItemcat();
}
