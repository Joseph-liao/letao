/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.jedis
 *
 *    Filename:    JedisTest.java
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
 *    Create at:   2017年4月22日 上午10:26:02
 *
 *    Revision:
 *
 *    2017年4月22日 上午10:26:02
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName JedisTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月22日 上午10:26:02
 * @version 1.0.0
 */
public class JedisTest {
    
    @Test
    public void testJedisPool(){
        JedisPool pool =new JedisPool("192.168.171.132", 6379);
        Jedis jedis = pool.getResource();
        jedis.set("a", "100");
        System.out.println(jedis.get("a"));
        jedis.close();
        pool.close();
    }

    @Test
    public void testJedisCluster() {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.171.132", 7001));
        nodes.add(new HostAndPort("192.168.171.132", 7002));
        nodes.add(new HostAndPort("192.168.171.132", 7003));
        nodes.add(new HostAndPort("192.168.171.132", 7004));
        nodes.add(new HostAndPort("192.168.171.132", 7005));
        nodes.add(new HostAndPort("192.168.171.132", 7006));
        
        JedisCluster cluster = new JedisCluster(nodes);
        
        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);
        
        cluster.close();
    }
    
    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        jedis.close();
        pool.close();
    }
    
    @Test
    public void testSpringJedisCluster() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");
        String string = jedisCluster.get("key1");
        System.out.println(string);
        jedisCluster.close();
    }
}

