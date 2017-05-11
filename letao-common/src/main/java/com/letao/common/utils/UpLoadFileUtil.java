/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.common.utils
 *
 *    Filename:    UpLoadFileUtil.java
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
 *    Create at:   2017年3月28日 下午7:49:21
 *
 *    Revision:
 *
 *    2017年3月28日 下午7:49:21
 *        - first revision
 *
 *****************************************************************/
package com.letao.common.utils;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName UpLoadFileUtil
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月28日 下午7:49:21
 * @version 1.0.0
 */
public class UpLoadFileUtil {
    public static boolean saveFile(String newFileName, MultipartFile filedata,String saveFilePath) {
        // TODO Auto-generated method stub
  
        System.out.println("存储路径为："+saveFilePath);
        boolean result=false;

        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        try {
            FileOutputStream out = new FileOutputStream(saveFilePath + "\\"
                    + newFileName);
            // 写入文件
            out.write(filedata.getBytes());
            result=true;
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}
