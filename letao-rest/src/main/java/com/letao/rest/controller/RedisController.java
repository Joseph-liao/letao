/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.controller
 *
 *    Filename:    RedisController.java
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
 *    Create at:   2017年4月25日 下午10:32:53
 *
 *    Revision:
 *
 *    2017年4月25日 下午10:32:53
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
import com.letao.rest.service.RedisService;

/**
 * @ClassName RedisController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月25日 下午10:32:53
 * @version 1.0.0
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
    
    @Autowired
    private RedisService redisService;
    
    @RequestMapping("/content/{contentCid}")
    @ResponseBody
    public LetaoResult contentCacheSync(@PathVariable Long contentCid) {
        LetaoResult result = redisService.syncContent(contentCid);
        return result;
    }
    
    @RequestMapping("/itemcat")
    @ResponseBody
    public LetaoResult itemCatCacheSync() {
        LetaoResult result = redisService.sycnItemcat();
        return result;
    }
}
