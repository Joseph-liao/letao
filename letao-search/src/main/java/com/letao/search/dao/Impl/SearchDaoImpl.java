/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.dao.Impl
 *
 *    Filename:    SearchDaoImpl.java
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
 *    Create at:   2017年5月4日 下午12:56:52
 *
 *    Revision:
 *
 *    2017年5月4日 下午12:56:52
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letao.search.dao.SearchDao;
import com.letao.search.pojo.Item;
import com.letao.search.pojo.SearchResult;


/**
 * @ClassName SearchDaoImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月4日 下午12:56:52
 * @version 1.0.0
 */
@Repository
public class SearchDaoImpl implements SearchDao {
    
    @Autowired
    private SolrServer solrServer;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.search.dao.SearchDao#search(org.apache.solr.client.solrj.SolrQuery)
     */
    @Override
    public SearchResult search(SolrQuery query) throws Exception {
        //创建返回结果对象
        SearchResult result =new SearchResult();
        //根据查询条件返回结果
        QueryResponse response = solrServer.query(query);
        SolrDocumentList documentList = response.getResults();
        //获取高亮显示
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        //设置返回结果数
        result.setRecordCount(documentList.getNumFound());
        //创建item集合
        List<Item> itemList =new ArrayList<Item>();
        for (SolrDocument solrDocument : documentList) {
            //创建一商品对象
            Item item = new Item();
            item.setId((String) solrDocument.get("id"));
            //取高亮显示的结果
            List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
            String title = "";
            if (list != null && list.size()>0) {
                title = list.get(0);
            } else {
                title = (String) solrDocument.get("item_title");
            }
            item.setTitle(title);
            item.setImage((String) solrDocument.get("item_image"));
            item.setPrice((long) solrDocument.get("item_price"));
            item.setSell_point((String) solrDocument.get("item_sell_point"));
            item.setCategory_name((String) solrDocument.get("item_category_name"));
            //添加的商品列表
            itemList.add(item);
        }
        result.setItemList(itemList);
        
        return result;
    }

}
