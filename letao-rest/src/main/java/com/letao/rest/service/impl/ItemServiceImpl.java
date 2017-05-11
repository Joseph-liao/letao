/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service.impl
 *
 *    Filename:    ItemServiceImpl.java
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
 *    Create at:   2017年5月9日 下午4:14:48
 *
 *    Revision:
 *
 *    2017年5月9日 下午4:14:48
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.common.utils.JsonUtils;
import com.letao.mapper.TbItemDescMapper;
import com.letao.mapper.TbItemMapper;
import com.letao.mapper.TbItemParamItemMapper;
import com.letao.pojo.TbItem;
import com.letao.pojo.TbItemDesc;
import com.letao.pojo.TbItemParamItem;
import com.letao.pojo.TbItemParamItemExample;
import com.letao.pojo.TbItemParamItemExample.Criteria;
import com.letao.rest.redis.dao.JedisClient;
import com.letao.rest.service.ItemService;


/**
 * @ClassName ItemServiceImpl
 * @Description TODO(商品信息serviceImpl)
 * @author 廖永乐
 * @Date 2017年5月9日 下午4:14:48
 * @version 1.0.0
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    
    @Autowired
    private TbItemDescMapper itemDescMapper;
    
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    
    @Autowired
    private JedisClient jedisClient;
    

    
    @Value("${REDIS_ITEM_KEY}")
    private String REDIS_ITEM_KEY;
    
    @Value("${REDIS_ITEM_EXPIRE}")
    private Integer REDIS_ITEM_EXPIRE;
    
    
    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.ItemService#getItemBaseInfo(long)
     */
    @Override
    public LetaoResult getItemBaseInfo(long itemId) {
        //获取缓存
        try {
            String json = jedisClient.get(REDIS_ITEM_KEY+":"+itemId+":base");
            if(StringUtils.isNotBlank(json)){
                   TbItem item=JsonUtils.jsonToPojo(json, TbItem.class);
                   return LetaoResult.ok(item);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //根据商品id查询商品信息
        TbItem item = itemMapper.selectByPrimaryKey(itemId);
        
        //添加缓存
        try {
            jedisClient.set(REDIS_ITEM_KEY+":"+itemId+":base",JsonUtils.objectToJson(item));
            //设置有效时间
            jedisClient.expire(REDIS_ITEM_KEY+":"+itemId+":base", REDIS_ITEM_EXPIRE);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //使用LetaoResult包装一下
        return LetaoResult.ok(item);
    }


    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.ItemService#getItemDesc(long)
     */
    @Override
    public LetaoResult getItemDesc(long itemId) {
        //添加缓存
        try {
            //添加缓存逻辑
            //从缓存中取商品信息，商品id对应的信息
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":desc");
            //判断是否有值
            if (!StringUtils.isBlank(json)) {
                //把json转换成java对象
                TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
                return LetaoResult.ok(itemDesc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建查询条件
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);
        
        try {
            //把商品信息写入缓存
            jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":desc", JsonUtils.objectToJson(itemDesc));
            //设置key的有效期
            jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc", REDIS_ITEM_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return LetaoResult.ok(itemDesc);
    }


    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.ItemService#getItemParam(long)
     */
    @Override
    public LetaoResult getItemParam(long itemId) {
        //添加缓存
        try {
            //添加缓存逻辑
            //从缓存中取商品信息，商品id对应的信息
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":param");
            //判断是否有值
            if (!StringUtils.isBlank(json)) {
                //把json转换成java对象
                TbItemParamItem paramItem = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
                return LetaoResult.ok(paramItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //根据商品id查询规格参数
        //设置查询条件
        TbItemParamItemExample example = new TbItemParamItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        //执行查询
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size()>0) {
            TbItemParamItem paramItem = list.get(0);
            try {
                //把商品信息写入缓存
                jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":param", JsonUtils.objectToJson(paramItem));
                //设置key的有效期
                jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":param", REDIS_ITEM_EXPIRE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return LetaoResult.ok(paramItem);
        }
        return LetaoResult.build(400, "无此商品规格");
    }

}
