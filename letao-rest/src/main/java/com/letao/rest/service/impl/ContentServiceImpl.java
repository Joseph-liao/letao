/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.service.impl
 *
 *    Filename:    ContentServiceImpl.java
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
 *    Create at:   2017年4月13日 下午9:11:45
 *
 *    Revision:
 *
 *    2017年4月13日 下午9:11:45
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.letao.common.utils.JsonUtils;
import com.letao.mapper.TbContentMapper;
import com.letao.pojo.TbContent;
import com.letao.pojo.TbContentExample;
import com.letao.pojo.TbContentExample.Criteria;
import com.letao.rest.redis.dao.JedisClient;
import com.letao.rest.service.ContentService;


/**
 * @ClassName ContentServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月13日 下午9:11:45
 * @version 1.0.0
 */
@Service
public class ContentServiceImpl implements ContentService {
    
    @Autowired
    private TbContentMapper contentMapper;
    
    @Autowired
    JedisClient jedisClient;
    
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.rest.service.ContentService#getContentList(long)
     */
    @Override
    public List<TbContent> getContentList(long contentCid) {
        //从缓存中取内容
        try {
            String result = jedisClient.hget(INDEX_CONTENT_REDIS_KEY, contentCid + "");
            if (!StringUtils.isBlank(result)) {
                //把字符串转换成list
                List<TbContent> resultList = JsonUtils.jsonToList(result, TbContent.class);
                return resultList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //根据内容分类id查询内容列表
        TbContentExample example = new TbContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(contentCid);
        //执行查询
        List<TbContent> list = contentMapper.selectByExample(example);
        
        //向缓存中添加内容
        try {
            //把list转换成字符串
            String cacheString = JsonUtils.objectToJson(list);
            jedisClient.hset(INDEX_CONTENT_REDIS_KEY, contentCid + "", cacheString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

}
