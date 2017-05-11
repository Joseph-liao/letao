/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.controller
 *
 *    Filename:    ItemController.java
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
 *    Create at:   2017年5月9日 下午4:16:46
 *
 *    Revision:
 *
 *    2017年5月9日 下午4:16:46
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.LetaoResult;
import com.letao.rest.service.ItemService;

/**
 * @ClassName ItemController
 * @Description TODO(商品详细信息controller)
 * @author 廖永乐
 * @Date 2017年5月9日 下午4:16:46
 * @version 1.0.0
 */
@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private ItemService itemService;
    
    /**
     * 
     * @Description (得到商品基本信息)
     * @param itemId
     * @return
     */
    @RequestMapping("/info/{itemId}")
    @ResponseBody
    public LetaoResult getItemBaseInfo(@PathVariable Long itemId) {
        LetaoResult result = itemService.getItemBaseInfo(itemId);
        return result;
    }
    
    /**
     * 
     * @Description (得到商品描述)
     * @param itemId
     * @return
     */
    @RequestMapping("/desc/{itemId}")
    @ResponseBody
    public LetaoResult getItemDesc(@PathVariable Long itemId) {
        LetaoResult result = itemService.getItemDesc(itemId);
        return result;
    }
    
    @RequestMapping("/param/{itemId}")
    @ResponseBody
    public LetaoResult getItemParam(@PathVariable Long itemId) {
        LetaoResult result = itemService.getItemParam(itemId);
        return result;
    }
}
