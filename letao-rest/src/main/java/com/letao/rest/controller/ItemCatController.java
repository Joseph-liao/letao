/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.controller
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
 *    Create at:   2017年4月8日 上午11:18:24
 *
 *    Revision:
 *
 *    2017年4月8日 上午11:18:24
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.rest.pojo.CatResult;
import com.letao.rest.service.ItemCatService;

/**
 * @ClassName ItemCatController
 * @Description TODO(商品目录Controller)
 * @author 廖永乐
 * @Date 2017年4月8日 上午11:18:24
 * @version 1.0.0
 */
@Controller
public class ItemCatController {
    
    @Autowired
    ItemCatService itemCatService;
    
    @RequestMapping("/itemcat/list")
    @ResponseBody
    public Object getCatResult(String callback){
        CatResult result = itemCatService.getCatResult();
        //springmvc4.1后提供的工具类，可快速将json拼装成js，并返回js
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(result);
        mappingJacksonValue.setJsonpFunction(callback);
    
        return mappingJacksonValue;
    }

}
