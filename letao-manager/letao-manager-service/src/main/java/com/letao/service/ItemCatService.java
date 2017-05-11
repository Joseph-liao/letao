/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    ItemCatService.java
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
 *    Create at:   2017年3月27日 下午3:09:41
 *
 *    Revision:
 *
 *    2017年3月27日 下午3:09:41
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import java.util.List;

import com.letao.common.pojo.EUTreeNode;

/**
 * @ClassName ItemCatService
 * @Description TODO(商品目录service)
 * @author 廖永乐
 * @Date 2017年3月27日 下午3:09:41
 * @version 1.0.0
 */
public interface ItemCatService {

    /**
     * 
     * @Description (根据商品目录父节点Id得到其子节点目录)
     * @param parentId
     * @return
     */
    public List<EUTreeNode> getItemCatList(long parentId);
}
