/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
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
 *    Create at:   2017年4月10日 下午8:09:06
 *
 *    Revision:
 *
 *    2017年4月10日 下午8:09:06
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.common.utils.HttpClientUtil;
import com.letao.mapper.TbContentMapper;
import com.letao.pojo.TbContent;
import com.letao.pojo.TbContentExample;
import com.letao.pojo.TbContentExample.Criteria;
import com.letao.service.ContentService;


/**
 * @ClassName ContentServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月10日 下午8:09:06
 * @version 1.0.0
 */
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    TbContentMapper contentMapper;
    
    @Value("${REDIS_BASE_URL}")
    private String REDIS_BASE_URL;
    
    @Value("${REDIS_CONTENT_SYNC_URL}")
    private String REDIS_CONTENT_SYNC_URL;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentService#getContentListByCategoryId(int, int, long)
     */
    @Override
    public EUDataGridResult getContentListByCategoryId(int page, int rows, long categoryId) {
        TbContentExample example =new TbContentExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(page, rows);
        List<TbContent> list = contentMapper.selectByExample(example);
        PageInfo<TbContent> pageInfo =new PageInfo<>(list);
        EUDataGridResult result =new EUDataGridResult();
        result.setRows(list);
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentService#insertContent(com.letao.pojo.TbContent)
     */
    @Override
    public LetaoResult insertContent(TbContent content) {
        content.setCreated(new Date());
        content.setUpdated(new Date());
        //设置图片的域名前缀
        content.setPic("http://localhost:8080/"+content.getPic());
        content.setPic2("http://localhost:8080/"+content.getPic2());
        
        contentMapper.insert(content);
        
        //添加缓存同步服务
        try {
            HttpClientUtil.doGet(REDIS_BASE_URL+REDIS_CONTENT_SYNC_URL+content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return LetaoResult.ok();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentService#deleteConetnts(java.lang.Long[])
     */
    @Override
    public LetaoResult deleteConetnts(Long[] ids) {
        for (Long id : ids) {
            TbContent content = contentMapper.selectByPrimaryKey(id);
            contentMapper.deleteByPrimaryKey(id);
            
            //添加缓存同步服务
            try {
                HttpClientUtil.doGet(REDIS_BASE_URL+REDIS_CONTENT_SYNC_URL+content.getCategoryId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return LetaoResult.ok();
    }

}
