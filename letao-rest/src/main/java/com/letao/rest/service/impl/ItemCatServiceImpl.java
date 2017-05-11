/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service.impl
 *
 *    Filename:    ItemCatServiceImpl.java
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
 *    Create at:   2017年4月8日 上午10:32:00
 *
 *    Revision:
 *
 *    2017年4月8日 上午10:32:00
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.letao.common.utils.JsonUtils;
import com.letao.mapper.TbItemCatMapper;
import com.letao.pojo.TbItemCat;
import com.letao.pojo.TbItemCatExample;
import com.letao.pojo.TbItemCatExample.Criteria;
import com.letao.rest.pojo.CatNode;
import com.letao.rest.pojo.CatResult;
import com.letao.rest.redis.dao.JedisClient;
import com.letao.rest.service.ItemCatService;


/**
 * @ClassName ItemCatServiceImpl
 * @Description TODO(商品目录service)
 * @author 廖永乐
 * @Date 2017年4月8日 上午10:32:00
 * @version 1.0.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    
    @Autowired
    TbItemCatMapper itemCatMappper;
    
    @Autowired
    JedisClient jedisClient;
    
    @Value("${INDEX_ITEMCAT_REDIS_KEY}")
    private String INDEX_ITEMCAT_REDIS_KEY;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.ItemCatService#getCatResult(java.lang.Long)
     */
    @Override
    public CatResult getCatResult() {
        
        //从缓存中读取商品目录
        try {
            String stringResult = jedisClient.get(INDEX_ITEMCAT_REDIS_KEY);
            if (!StringUtils.isBlank(stringResult)) {
                 CatResult catResult = JsonUtils.jsonToPojo(stringResult, CatResult.class);
                return catResult;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        CatResult catResult =new CatResult();
        catResult.setData(getCatList(0));
        
        //将商品目录内容放到缓存中
        try {
            //把list转换为字符串
            String cacheString = JsonUtils.objectToJson(catResult);
            jedisClient.set(INDEX_ITEMCAT_REDIS_KEY, cacheString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return catResult;
        

    }
    
    
    /**
     * 
     * @Description (根据父节点递归出全部商品目录，并赋值给catNode)
     * @param parentId
     * @return
     */
    private List<?> getCatList(long parentId){        
        TbItemCatExample example =new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMappper.selectByExample(example);
        
        List resultList =new ArrayList<>();
        int count=0;
        for (TbItemCat itemCat : list) {
            //判断该节点有没有子节点
            if(itemCat.getIsParent()){
              CatNode node =new CatNode();
              //第一层目录的名字是a标签
              if(itemCat.getParentId()==0){
                  node.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
              }else{
                  node.setName(itemCat.getName());
              }
              node.setUrl("/products/"+itemCat.getId()+".html");
              //递归其子节点
              node.setItem(getCatList(itemCat.getId()));
              resultList.add(node);
              //限制首目录取出记录为14条
              count++;
              if(parentId==0&&count>14){
                  break;
              }
            }
            //如果是叶子节点
            else{
                resultList.add("/products/"+itemCat.getId()+".html|" + itemCat.getName());
            }            
        }
        
        return resultList;
        
    }

}
