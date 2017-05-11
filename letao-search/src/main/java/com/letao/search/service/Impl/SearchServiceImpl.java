/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.service.Impl
 *
 *    Filename:    SearchServiceImpl.java
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
 *    Create at:   2017年5月4日 下午4:42:51
 *
 *    Revision:
 *
 *    2017年5月4日 下午4:42:51
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.service.Impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letao.search.dao.SearchDao;
import com.letao.search.pojo.SearchResult;
import com.letao.search.service.SearchService;


/**
 * @ClassName SearchServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月4日 下午4:42:51
 * @version 1.0.0
 */
@Service
public class SearchServiceImpl implements SearchService {
    
    @Autowired
    private SearchDao searchDao;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.search.service.SearchService#search(java.lang.String, int, int)
     */
    @Override
    public SearchResult search(String queryString, int page, int rows) throws Exception {
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setQuery(queryString);
        //设置分页
        solrQuery.setStart((page-1)*rows);
        solrQuery.setRows(rows);
        //设置默认搜索域
        solrQuery.set("df", "item_keywords");
        //设置高亮显示
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("item_title");
        solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
        solrQuery.setHighlightSimplePost("</em>");
        //执行查询
        SearchResult searchResult = searchDao.search(solrQuery);
        //计算查询结果总页数
        long recordCount = searchResult.getRecordCount();
        long pageCount = recordCount / rows;
        if (recordCount % rows > 0) {
            pageCount++;
        }
        searchResult.setPageCount(pageCount);
        searchResult.setCurPage(page);
        
        return searchResult;
    }

}
