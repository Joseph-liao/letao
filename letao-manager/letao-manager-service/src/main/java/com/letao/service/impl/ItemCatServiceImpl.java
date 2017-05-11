/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
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
 *    Create at:   2017年3月27日 下午3:12:56
 *
 *    Revision:
 *
 *    2017年3月27日 下午3:12:56
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.EUTreeNode;
import com.letao.mapper.TbItemCatMapper;
import com.letao.pojo.TbItemCat;
import com.letao.pojo.TbItemCatExample;
import com.letao.pojo.TbItemCatExample.Criteria;
import com.letao.service.ItemCatService;


/**
 * @ClassName ItemCatServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月27日 下午3:12:56
 * @version 1.0.0
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
    
    @Autowired
    private TbItemCatMapper itemCatMapper;
    
    
    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemCatService#getItemCatList(long)
     */
    @Override
    public List<EUTreeNode> getItemCatList(long parentId) {
        TbItemCatExample example =new TbItemCatExample();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        List<EUTreeNode> resultList=new ArrayList<EUTreeNode>();
        //将查询结果转换为EUTreeNode结构的list
        for(TbItemCat itemCat:list){
            EUTreeNode node =new EUTreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            node.setState(itemCat.getIsParent()?"closed":"open");
            resultList.add(node);
        }
        
        return resultList;
    }

}
