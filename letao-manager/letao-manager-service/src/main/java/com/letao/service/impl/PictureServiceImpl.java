/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
 *
 *    Filename:    PictureServiceImpl.java
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
 *    Create at:   2017年3月28日 下午7:47:29
 *
 *    Revision:
 *
 *    2017年3月28日 下午7:47:29
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.mapping.ResultMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.letao.common.utils.IDUtils;
import com.letao.common.utils.UpLoadFileUtil;
import com.letao.service.PictureService;


/**
 * @ClassName PictureServiceImpl
 * @Description TODO(上传图片service)
 * @author 廖永乐
 * @Date 2017年3月28日 下午7:47:29
 * @version 1.0.0
 */
@Service
public class PictureServiceImpl implements PictureService {

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.PictureService#UpLoadPicture(org.springframework.web.multipart.MultipartFile)
     */
    @Override
    public Map UpLoadPicture(MultipartFile file,String dir,String address) {
        // TODO Auto-generated method stub
        Map resultMap =new HashMap();
        if (file != null && !file.isEmpty()) {
            // 获取图片的文件名
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            // 获取图片的扩展名
            String extensionName = fileName
                    .substring(fileName.lastIndexOf(".") + 1);
            // 新的图片文件名 = 获取时间戳+"."图片扩展名
            String newFileName = IDUtils.genImageName()
                    + "." + extensionName;
            
            //String dir = request.getServletContext().getRealPath("/");
            String saveFilePath =dir + "image";
            String returnPath=address+"/image"+"/"+newFileName;
            
            //图片路径为
            String imgPath=saveFilePath+ "\\" + newFileName;
            boolean result=false;
           
            try {
                //driver.setPicUrl(newFileName);
               result = UpLoadFileUtil.saveFile(newFileName, file, saveFilePath);
               // saveFile(newFileName, file,saveFilePath);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if(!result){
                resultMap.put("error", 1);
                resultMap.put("message", "文件上传失败");
            }else{
                resultMap.put("error", 0);
                resultMap.put("url",returnPath);
            }
        }
        
        return resultMap;
    }

}
