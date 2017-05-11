/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.redis.dao.impl
 *
 *    Filename:    JedisClientSingle.java
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
 *    Create at:   2017年4月23日 下午10:35:14
 *
 *    Revision:
 *
 *    2017年4月23日 下午10:35:14
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.redis.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.letao.rest.redis.dao.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @ClassName JedisClientSingle
 * @Description TODO(Jedis单机版dao)
 * @author 廖永乐
 * @Date 2017年4月23日 下午10:35:14
 * @version 1.0.0
 */
public class JedisClientSingle implements JedisClient {
    
    @Autowired
    private JedisPool jedisPool; 

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#set(java.lang.String, java.lang.String)
     */
    @Override
    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#get(java.lang.String)
     */
    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#hset(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public Long hset(String hkey, String key, String value) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hset(hkey,key ,value);
        jedis.close();
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#hget(java.lang.String, java.lang.String)
     */
    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#incr(java.lang.String)
     */
    @Override
    public long incr(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#expire(java.lang.String, long)
     */
    @Override
    public long expire(String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#ttl(java.lang.String)
     */
    @Override
    public long ttl(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#del(java.lang.String)
     */
    @Override
    public long del(String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.redis.dao.JedisClient#hdel(java.lang.String, java.lang.String)
     */
    @Override
    public long hdel(String hkey, String key) {
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }

}
