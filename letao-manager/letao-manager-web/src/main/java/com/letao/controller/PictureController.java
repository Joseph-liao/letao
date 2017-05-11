/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.controller
 *
 *    Filename:    PictureController.java
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
 *    Create at:   2017年3月28日 下午11:39:30
 *
 *    Revision:
 *
 *    2017年3月28日 下午11:39:30
 *        - first revision
 *
 *****************************************************************/
package com.letao.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.letao.service.PictureService;

/**
 * @ClassName PictureController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月28日 下午11:39:30
 * @version 1.0.0
 */
@Controller
@RequestMapping("/pic")
public class PictureController {
    
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public Map uploda(@RequestParam("uploadFile") CommonsMultipartFile file,HttpServletRequest request) throws Exception {
        //调用service上传图片
        String dir=request.getSession().getServletContext().getRealPath("/");
        Map map = pictureService.UpLoadPicture(file, dir,request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort());
        String parameter = request.getParameter("image");
        //返回上传结果
        return map;
        
    }
}
