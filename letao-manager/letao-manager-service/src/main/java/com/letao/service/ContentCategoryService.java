/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    ContentCategoryService.java
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
 *    Create at:   2017年4月8日 下午4:31:38
 *
 *    Revision:
 *
 *    2017年4月8日 下午4:31:38
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import java.util.List;

import com.letao.common.pojo.EUTreeNode;
import com.letao.common.pojo.LetaoResult;

/**
 * @ClassName ContentCategoryService
 * @Description TODO(内容管理service)
 * @author 廖永乐
 * @Date 2017年4月8日 下午4:31:38
 * @version 1.0.0
 */
public interface ContentCategoryService {

    /**
     * 
     * @Description (查找内容目录)
     * @param parentId
     * @return
     */
    public List<EUTreeNode> getCategoryList(long parentId);
    
    /**
     * 
     * @Description (插入内容目录)
     * @param parentId
     * @param name
     * @return
     */
    
    public LetaoResult insertContentCategory(long parentId, String name); 
    
    /**
     * 
     * @Description (删除内容目录)
     * @param parentId
     * @param id
     * @return
     */
    public LetaoResult deleteContentCategory(long id);
    
    /**
     * 
     * @Description (重命名内容目录)
     * @param id
     * @param text
     * @return
     */
    public LetaoResult updateContentCategory(long id,String text);
}
