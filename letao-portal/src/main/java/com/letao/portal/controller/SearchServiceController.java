/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.controller
 *
 *    Filename:    SearchServiceController.java
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
 *    Create at:   2017年5月8日 上午10:20:40
 *
 *    Revision:
 *
 *    2017年5月8日 上午10:20:40
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.letao.common.pojo.SearchResult;
import com.letao.portal.service.SearchService;

/**
 * @ClassName SearchServiceController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月8日 上午10:20:40
 * @version 1.0.0
 */
@Controller
public class SearchServiceController {

    @Autowired
    private SearchService searchService;
    
    @RequestMapping("/search")
    public String search(@RequestParam("q") String queryString,
            @RequestParam(defaultValue="1") Integer page,Model model){
        if(queryString!=null){
            try {
                queryString=new String(queryString.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        SearchResult searchResult = searchService.search(queryString, page);
        //向页面传递参数
        model.addAttribute("query", queryString);
        model.addAttribute("totalPages", searchResult.getPageCount());
        model.addAttribute("itemList", searchResult.getItemList());
        model.addAttribute("page", page);
        
        return "search";
    }
}
