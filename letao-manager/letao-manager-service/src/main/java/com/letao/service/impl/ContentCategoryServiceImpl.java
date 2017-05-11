/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
 *
 *    Filename:    ContentCategoryServiceImpl.java
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
 *    Create at:   2017年4月8日 下午4:33:09
 *
 *    Revision:
 *
 *    2017年4月8日 下午4:33:09
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.EUTreeNode;
import com.letao.common.pojo.LetaoResult;
import com.letao.mapper.TbContentCategoryMapper;
import com.letao.pojo.TbContentCategory;
import com.letao.pojo.TbContentCategoryExample;
import com.letao.pojo.TbContentCategoryExample.Criteria;
import com.letao.service.ContentCategoryService;


/**
 * @ClassName ContentCategoryServiceImpl
 * @Description TODO(内容管理service)
 * @author 廖永乐
 * @Date 2017年4月8日 下午4:33:09
 * @version 1.0.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper contentCategoryMapper;
    
    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentCategoryService#getCategoryList(long)
     */
    @Override
    public List<EUTreeNode> getCategoryList(long parentId) {
      //根据parentid查询节点列表
        TbContentCategoryExample example = new TbContentCategoryExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //执行查询
        List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
        List<EUTreeNode> resultList = new ArrayList<>();
        for (TbContentCategory tbContentCategory : list) {
            //创建一个节点
            EUTreeNode node = new EUTreeNode();
            node.setId(tbContentCategory.getId());
            node.setText(tbContentCategory.getName());
            node.setState(tbContentCategory.getIsParent()?"closed":"open");
            
            resultList.add(node);
        }
        return resultList;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentCategoryService#insertContentCategory(long, java.lang.String)
     */
    @Override
    public LetaoResult insertContentCategory(long parentId, String name) {
      //创建一个pojo
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setName(name);
        contentCategory.setIsParent(false);
        //'状态。可选值:1(正常),2(删除)',
        contentCategory.setStatus(1);
        contentCategory.setParentId(parentId);
        contentCategory.setSortOrder(1);
        contentCategory.setCreated(new Date());
        contentCategory.setUpdated(new Date());
        //添加记录
        contentCategoryMapper.insert(contentCategory);
        //查看父节点的isParent列是否为true，如果不是true改成true
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
        //判断是否为true
        if(!parentCat.getIsParent()) {
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        //返回结果
        return LetaoResult.ok(contentCategory);
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentCategoryService#deleteContentCategory(long, long)
     */
    @Override
    public LetaoResult deleteContentCategory(long id) {
        TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
        LetaoResult result =new LetaoResult();
        int i = contentCategoryMapper.deleteByPrimaryKey(id);
        if(i<1){
            result.setMsg("找不到该数据");
            result.setStatus(404);
            return result;
        }
        //查看父节点的isParent列是否为true，如果不是true改成true
        TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(category.getParentId());
        //判断是否为true
        if(!parentCat.getIsParent()) {
            parentCat.setIsParent(true);
            //更新父节点
            contentCategoryMapper.updateByPrimaryKey(parentCat);
        }
        
        return LetaoResult.ok();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ContentCategoryService#updateContentCategory(long, java.lang.String)
     */
    @Override
    public LetaoResult updateContentCategory(long id, String text) {
        TbContentCategory category = contentCategoryMapper.selectByPrimaryKey(id);
        category.setName(text);
        contentCategoryMapper.updateByPrimaryKey(category);
        return LetaoResult.ok();
    }

}
