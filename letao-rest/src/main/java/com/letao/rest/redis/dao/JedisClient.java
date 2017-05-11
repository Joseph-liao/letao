/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.redis.dao
 *
 *    Filename:    JedisClient.java
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
 *    Create at:   2017年4月23日 下午10:12:16
 *
 *    Revision:
 *
 *    2017年4月23日 下午10:12:16
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.redis.dao;


/**
 * @ClassName JedisClient
 * @Description TODO(JedisDao)
 * @author 廖永乐
 * @Date 2017年4月23日 下午10:12:16
 * @version 1.0.0
 */
public interface JedisClient {

    /**
     * 
     * @Description (Redis set)
     * @param key
     * @param value
     * @return
     */
    String set(String key,String value);
    
    /**
     * 
     * @Description (Redis get)
     * @param key
     * @return
     */
    String get(String key);
    
    /**
     * 
     * @Description (Redis hset:Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。)
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    Long hset(String hkey,String key,String value);
    
    /**
     * 
     * @Description (Redis hget:获取存储在哈希表中指定字段的值。)
     * @param hkey
     * @param key
     * @return
     */
    String hget(String hkey,String key);
    
    /**
     * 
     * @Description (将 key 中储存的数字值增一)
     * @param key
     * @return
     */
    long incr(String key);
    
    /**
     * 
     * @Description (为给定 key 设置生存时间，当 key 过期时(生存时间为 0 )，它会被自动删除)
     * @param key
     * @param second
     * @return
     */
    long expire(String key,int second);
    
    /**
     * 
     * @Description (Redis TTL 命令以秒为单位返回 key 的剩余过期时间,当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间)
     * @param key
     * @return
     */
    long ttl(String key);
    
    /**
     * 
     * @Description (根据键删除缓存)
     * @param key
     * @return
     */
    long del(String key);
    
    /**
     * 
     * @Description (根据哈希key与键删除缓存)
     * @param heky
     * @param key
     * @return
     */
    long hdel(String hkey,String key);
    
    
}
