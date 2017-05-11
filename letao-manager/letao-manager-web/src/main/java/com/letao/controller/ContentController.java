/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    ContentController.java
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
 *    Create at:   2017年4月10日 下午8:17:41
 *
 *    Revision:
 *
 *    2017年4月10日 下午8:17:41
 *        - first revision
 *
 *****************************************************************/
package com.letao.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbContent;
import com.letao.service.ContentService;

/**
 * @ClassName ContentController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月10日 下午8:17:41
 * @version 1.0.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    ContentService contentService;
    
    /**
     * 
     * @Description (返回EasyUi的商品内容列表)
     * @param page
     * @param rows
     * @param categoryId
     * @return
     */
    @RequestMapping("/query/list")
    @ResponseBody
    public EUDataGridResult getContentListByCategoryId(int page, int rows, long categoryId){
        EUDataGridResult result = contentService.getContentListByCategoryId(page, rows, categoryId);
        return result;
    }
    
    /**
     * 
     * @Description (添加商品内容)
     * @param content
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public LetaoResult insertContent(TbContent content) {
        //content.setId(123L);
        LetaoResult result = contentService.insertContent(content);
        return result;
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public LetaoResult deleteContent(HttpServletRequest request){
        String ids = request.getParameter("ids");
        String[] split = ids.split(",");
        List<Long> LongId=new ArrayList<Long>();
        for (String string : split) {
            long id = Long.parseLong(string);
            LongId.add(id);
        }
        LetaoResult result = contentService.deleteConetnts(LongId.toArray(new Long[LongId.size()]));
        return result;
    }
}
