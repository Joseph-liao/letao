/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.dao
 *
 *    Filename:    SearchDao.java
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
 *    Create at:   2017年5月4日 下午12:53:00
 *
 *    Revision:
 *
 *    2017年5月4日 下午12:53:00
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.letao.search.pojo.SearchResult;

/**
 * @ClassName SearchDao
 * @Description TODO(搜索dao)
 * @author 廖永乐
 * @Date 2017年5月4日 下午12:53:00
 * @version 1.0.0
 */
public interface SearchDao {
    
    /**
     * 
     * @Description (根据搜索条件搜索dao)
     * @param query
     * @return
     * @throws Exception
     */
    public SearchResult search(SolrQuery query) throws Exception;

}
