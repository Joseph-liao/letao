/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.search.controller
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
 *    Create at:   2017年5月3日 下午1:38:15
 *
 *    Revision:
 *
 *    2017年5月3日 下午1:38:15
 *        - first revision
 *
 *****************************************************************/
package com.letao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.LetaoResult;
import com.letao.search.service.ItemService;

/**
 * @ClassName ItemController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月3日 下午1:38:15
 * @version 1.0.0
 */
@Controller
@RequestMapping("/manager")
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @RequestMapping("/importall")
    @ResponseBody
    public LetaoResult improtAllItems(){
        LetaoResult result = itemService.improtAllItem();
        return result;
    }
}
