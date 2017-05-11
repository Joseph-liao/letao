/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.controller
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
 *    Create at:   2017年4月13日 下午9:12:42
 *
 *    Revision:
 *
 *    2017年4月13日 下午9:12:42
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.controller;

import java.util.List;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbContent;
import com.letao.rest.service.ContentService;

/**
 * @ClassName ContentController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月13日 下午9:12:42
 * @version 1.0.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;
    
    @RequestMapping("/list/{contentCategoryId}")
    @ResponseBody
    public LetaoResult getContentList(@PathVariable long contentCategoryId) {
        try {
            //Long contentCategoryId=89l;
            List<TbContent> list = contentService.getContentList(contentCategoryId);
            return LetaoResult.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return LetaoResult.build(500, e.getMessage());
        }
    }
}
