/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.controller
 *
 *    Filename:    SearchController.java
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
 *    Create at:   2017年5月5日 上午11:49:56
 *
 *    Revision:
 *
 *    2017年5月5日 上午11:49:56
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.letao.common.pojo.LetaoResult;
import com.letao.search.pojo.SearchResult;
import com.letao.search.service.SearchService;

/**
 * @ClassName SearchController
 * @Description TODO(搜索controller)
 * @author 廖永乐
 * @Date 2017年5月5日 上午11:49:56
 * @version 1.0.0
 */
@Controller
public class SearchController {

    @Autowired
    SearchService searchService;
    
    /**
     * 
     * @Description (根据查询条件和分页搜索)
     * @param queryString
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public LetaoResult  search(@RequestParam("q")String queryString, 
            @RequestParam(defaultValue="1")Integer page, 
            @RequestParam(defaultValue="60")Integer rows) {
        if(StringUtils.isBlank(queryString)){
            return LetaoResult.build(400, "查询条件不能为空");
        }
        SearchResult searchResult=null;
        try {
            queryString =new String(queryString.getBytes("iso8859-1"),"utf-8");
            searchResult = searchService.search(queryString, page, rows);
        } catch (Exception e) {
            e.printStackTrace();
            return LetaoResult.build(500, e.getMessage());
        }
        
        return LetaoResult.ok(searchResult);
    }
}
