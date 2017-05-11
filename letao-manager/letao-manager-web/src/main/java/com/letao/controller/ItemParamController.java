/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    ItemParamController.java
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
 *    Create at:   2017年3月31日 下午4:01:39
 *
 *    Revision:
 *
 *    2017年3月31日 下午4:01:39
 *        - first revision
 *
 *****************************************************************/
package com.letao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbItemParam;
import com.letao.service.ItemParamService;

/**
 * @ClassName ItemParamController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月31日 下午4:01:39
 * @version 1.0.0
 */
@Controller
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;
    
    @RequestMapping("/item/param/query/itemcatid/{itemCatId}")
    @ResponseBody
    public LetaoResult getItemParamByCid(@PathVariable Long itemCatId) {
        LetaoResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }
    
    @RequestMapping("/item/param/save/{cid}")
    @ResponseBody
    public LetaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        //创建pojo对象
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        LetaoResult result = itemParamService.insertItemParam(itemParam);
        return result;
    }
    
    @RequestMapping("/item/param/list")
    @ResponseBody
    public EUDataGridResult getItemParamList(Integer page, Integer rows){
        EUDataGridResult result = itemParamService.getItemParamList(page, rows);
 /*       List<TbItemParam> list = (List<TbItemParam>) result.getRows();
        for(TbItemParam p:list){
            System.out.println(p.getParamData());
        }*/
        return result;
    }
    
    @RequestMapping("/item/param/delete")
    @ResponseBody
    public LetaoResult deleteItemParams(HttpServletRequest request){
        String ids = request.getParameter("ids");
        String[] split = ids.split(",");
        List<Long> LongId=new ArrayList<Long>();
        for (String string : split) {
            long id = Long.parseLong(string);
            LongId.add(id);
        }
        LetaoResult result = itemParamService.deleteItemParams(LongId.toArray(new Long[LongId.size()]));
        return result;
    }
    
    @RequestMapping("/item/param/reload/{id}")
    @ResponseBody
    public LetaoResult getItemParamById(@PathVariable Long id){
        String paramData = itemParamService.getParamDataById(id);
        System.out.println(1);
        return LetaoResult.ok(paramData);
    }
}
