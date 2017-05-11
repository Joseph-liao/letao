/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.pojo
 *
 *    Filename:    ItemInfo.java
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
 *    Create at:   2017年5月10日 下午2:40:59
 *
 *    Revision:
 *
 *    2017年5月10日 下午2:40:59
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.pojo;

import com.letao.pojo.TbItem;


/**
 * @ClassName ItemInfo
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月10日 下午2:40:59
 * @version 1.0.0
 */
public class ItemInfo extends TbItem {
    
    public String[] getImages(){
        String image=getImage();
        if(image!=null){
            String [] images=image.split(",");
            return images;
        }
        return null;
    }

}
