/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.service
 *
 *    Filename:    SearchService.java
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
 *    Create at:   2017年5月4日 下午4:41:17
 *
 *    Revision:
 *
 *    2017年5月4日 下午4:41:17
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.service;

import com.letao.search.pojo.SearchResult;

/**
 * @ClassName SearchService
 * @Description TODO(搜索服务service)
 * @author 廖永乐
 * @Date 2017年5月4日 下午4:41:17
 * @version 1.0.0
 */
public interface SearchService {

    /**
     * 
     * @Description (搜索，设置page和rows)
     * @param queryString
     * @param page
     * @param rows
     * @return
     * @throws Exception
     */
    public SearchResult search(String queryString, int page, int rows) throws Exception;
}
