/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.mapper
 *
 *    Filename:    ItemMapper.java
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
 *    Create at:   2017年5月3日 上午11:52:28
 *
 *    Revision:
 *
 *    2017年5月3日 上午11:52:28
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.mapper;

import java.util.List;

import com.letao.search.pojo.Item;

/**
 * @ClassName ItemMapper
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月3日 上午11:52:28
 * @version 1.0.0
 */
public interface ItemMapper {
    
    public List<Item> getItemList();

}
