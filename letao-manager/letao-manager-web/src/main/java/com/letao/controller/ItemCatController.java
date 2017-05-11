/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    ItemCatController.java
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
 *    Create at:   2017年3月27日 下午3:52:48
 *
 *    Revision:
 *
 *    2017年3月27日 下午3:52:48
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
import com.letao.service.ItemCatService;



/**
 * @ClassName ItemCatController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月27日 下午3:52:48
 * @version 1.0.0
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    
    @Autowired
    private ItemCatService itemCatService;
    
    /**
     * 
     * @Description (得到商品目录)
     * @param parentId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0") long parentId){
        List<EUTreeNode> list = itemCatService.getItemCatList(parentId);       
        return list;
    }
}
