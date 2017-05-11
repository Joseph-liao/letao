/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    ItemParamItemController.java
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
 *    Create at:   2017年4月1日 上午11:23:07
 *
 *    Revision:
 *
 *    2017年4月1日 上午11:23:07
 *        - first revision
 *
 *****************************************************************/
package com.letao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.LetaoResult;
import com.letao.service.ItemParamItemService;


/**
 * @ClassName ItemParamItemController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月1日 上午11:23:07
 * @version 1.0.0
 */
@Controller
public class ItemParamItemController {
    
    @Autowired
    private ItemParamItemService itemParamItemService;
    
    @RequestMapping("/showItem/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String string = itemParamItemService.getItemParamByItemId(itemId);
        model.addAttribute("itemParam", string);
        return "item";
    }
    
    @RequestMapping("/rest/item/param/item/query/{itemId}")
    @ResponseBody
    public LetaoResult queryItemParamItemByItemId(@PathVariable Long itemId){
        LetaoResult result = itemParamItemService.queryItemParamByItemId(itemId);
        return result;
    }
    
/*    @RequestMapping("/item/param/delete")
    @ResponseBody
    public LetaoResult deleteItemParamItems(HttpServletRequest request){
        String ids = request.getParameter("ids");
        String[] split = ids.split(",");
        List<Long> LongId=new ArrayList<Long>();
        for (String string : split) {
            long id = Long.parseLong(string);
            LongId.add(id);
        } 
        LetaoResult result = itemParamItemService.deleteItemParams(LongId.toArray(new Long[LongId.size()]));
        return result;
    }*/
}
