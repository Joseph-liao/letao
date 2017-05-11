/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    ContentCategoryController.java
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
 *    Create at:   2017年4月8日 下午4:35:58
 *
 *    Revision:
 *
 *    2017年4月8日 下午4:35:58
 *        - first revision
 *
 *****************************************************************/
package com.letao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.EUTreeNode;
import com.letao.common.pojo.LetaoResult;
import com.letao.service.ContentCategoryService;

/**
 * @ClassName ContentCategoryController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月8日 下午4:35:58
 * @version 1.0.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;
    
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
        List<EUTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }
    
    @RequestMapping("/create")
    @ResponseBody
    public LetaoResult createContentCategory(Long parentId, String name) {
        LetaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }
    
    @RequestMapping("/delete")
    @ResponseBody
    public LetaoResult deleteContentCategory(Long id){
        LetaoResult result = contentCategoryService.deleteContentCategory(id);
        return result;
    }
    
    @RequestMapping("/update")
    @ResponseBody
    public LetaoResult updateContentCategory(Long id,String name){
        LetaoResult result = contentCategoryService.updateContentCategory(id, name);
        return result;
    }
}
