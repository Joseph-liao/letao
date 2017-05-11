/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    PictureService.java
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
 *    Create at:   2017年3月28日 下午7:45:35
 *
 *    Revision:
 *
 *    2017年3月28日 下午7:45:35
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PictureService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月28日 下午7:45:35
 * @version 1.0.0
 */
public interface PictureService {

    /**
     * 
     * @Description (上传图片)
     * @param upLoadFile
     * @return
     */
    public Map UpLoadPicture(MultipartFile file,String dir,String returnPath);
}
