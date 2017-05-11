/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service.impl
 *
 *    Filename:    RedisServiceImpl.java
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
 *    Create at:   2017年4月25日 下午10:25:26
 *
 *    Revision:
 *
 *    2017年4月25日 下午10:25:26
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.rest.redis.dao.JedisClient;
import com.letao.rest.service.RedisService;


/**
 * @ClassName RedisServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月25日 下午10:25:26
 * @version 1.0.0
 */
@Service
public class RedisServiceImpl implements RedisService {
    
    @Autowired
    private JedisClient jedisClient;
    
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;
    
    @Value("${INDEX_ITEMCAT_REDIS_KEY}")
    private String INDEX_ITEMCAT_REDIS_KEY;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.RedisService#syncContent(long)
     */
    @Override
    public LetaoResult syncContent(long contentCid) {
        try {
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contentCid+"");
        } catch (Exception e) {
            return LetaoResult.build(500,e.getMessage());
        }
        return LetaoResult.ok();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.RedisService#sycnItemcat()
     */
    @Override
    public LetaoResult sycnItemcat() {
        try {
            jedisClient.del(INDEX_ITEMCAT_REDIS_KEY);
        } catch (Exception e) {
            return LetaoResult.build(500, e.getMessage());
        }
        return LetaoResult.ok();
    }
}
