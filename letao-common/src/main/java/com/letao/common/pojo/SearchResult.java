/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.pojo
 *
 *    Filename:    SearchResult.java
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
 *    Create at:   2017年5月4日 下午12:51:27
 *
 *    Revision:
 *
 *    2017年5月4日 下午12:51:27
 *        - first revision
 *
 *****************************************************************/
package com.letao.common.pojo;

import java.util.List;

/**
 * @ClassName SearchResult
 * @Description TODO(搜索结果pojo)
 * @author 廖永乐
 * @Date 2017年5月4日 下午12:51:27
 * @version 1.0.0
 */
public class SearchResult {

    //商品列表
    private List<Item> itemList;
    //总记录数
    private long recordCount;
    //总页数
    private long pageCount;
    //当前页
    private long curPage;
    
    /**
     * @return the itemList
     */
    public List<Item> getItemList() {
        return itemList;
    }
    
    /**
     * @param itemList the itemList to set
     */
    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    
    /**
     * @return the recordCount
     */
    public long getRecordCount() {
        return recordCount;
    }
    
    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }
    
    /**
     * @return the pageCount
     */
    public long getPageCount() {
        return pageCount;
    }
    
    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
    
    /**
     * @return the curPage
     */
    public long getCurPage() {
        return curPage;
    }
    
    /**
     * @param curPage the curPage to set
     */
    public void setCurPage(long curPage) {
        this.curPage = curPage;
    }
}
