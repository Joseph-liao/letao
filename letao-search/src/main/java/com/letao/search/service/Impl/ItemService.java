/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.service.Impl
 *
 *    Filename:    ItemService.java
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
 *    Create at:   2017年5月3日 下午1:21:10
 *
 *    Revision:
 *
 *    2017年5月3日 下午1:21:10
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.service.Impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.search.mapper.ItemMapper;
import com.letao.search.pojo.Item;


/**
 * @ClassName ItemService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月3日 下午1:21:10
 * @version 1.0.0
 */
@Service
public class ItemService implements com.letao.search.service.ItemService {
    
    @Autowired
    private ItemMapper itemMapper;
    
    @Autowired
    private HttpSolrServer solrServer;
    
    @Value("${SOLR_SERVER_URL}")
    private String SOLR_SERVER_URL;
    

    /* (非 Javadoc)
     * Description:
     * @see com.letao.search.service.ItemService#improtAllItem()
     */
    @Override
    public LetaoResult improtAllItem() {
        //创建一连接
        boolean equals = SOLR_SERVER_URL.equals("http://192.168.171.132:8080/solr");
     //   SolrServer solrServer = new HttpSolrServer("http://192.168.171.132:8080/solr");
        List<Item> list = itemMapper.getItemList();
        try {
            for (Item item : list) {
                SolrInputDocument document =new SolrInputDocument();
                document.setField("id", item.getId());
                document.setField("item_title", item.getTitle());
                document.setField("item_sell_point", item.getSell_point());
                document.setField("item_price", item.getPrice());
                document.setField("item_image", item.getImage());
                document.setField("item_category_name", item.getCategory_name());
                document.setField("item_desc", item.getItem_des());
                
                //写入索引库
                solrServer.add(document);          
            }
            //提交修改
            solrServer.commit();
        } catch (Exception e) {
            return LetaoResult.build(500, e.getMessage());                    
        }
        return LetaoResult.ok();
    }

}
