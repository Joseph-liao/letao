/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.service
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
 *    Create at:   2017年5月7日 下午9:11:02
 *
 *    Revision:
 *
 *    2017年5月7日 下午9:11:02
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.service;

import com.letao.common.pojo.SearchResult;

/**
 * @ClassName SearchService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月7日 下午9:11:02
 * @version 1.0.0
 */
public interface SearchService {

    /**
     * 
     * @Description (搜索服务)
     * @param queryString
     * @param page
     * @return
     */
    public SearchResult search(String queryString, int page);
}
