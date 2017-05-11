/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.redis.dao.impl
 *
 *    Filename:    JedisCluster.java
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
 *    Create at:   2017年4月23日 下午11:00:16
 *
 *    Revision:
 *
 *    2017年4月23日 下午11:00:16
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.letao.rest.redis.dao.JedisClient;

import redis.clients.jedis.JedisCluster;


/**
 * @ClassName JedisCluster
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月23日 下午11:00:16
 * @version 1.0.0
 */

public class JedisClientCluster implements JedisClient {

    @Autowired
    private JedisCluster jedisCluster;
    
    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key, value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, int second) {
        return jedisCluster.expire(key, second);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#del(java.lang.String)
     */
    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#hdel(java.lang.String, java.lang.String)
     */
    @Override
    public long hdel(String hkey, String key) {        
        return jedisCluster.hdel(hkey, key);
    }

}