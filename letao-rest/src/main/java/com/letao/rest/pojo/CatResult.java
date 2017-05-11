/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.rest.pojo
 *
 *    Filename:    CatResult.java
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
 *    Create at:   2017年4月8日 上午10:26:33
 *
 *    Revision:
 *
 *    2017年4月8日 上午10:26:33
 *        - first revision
 *
 *****************************************************************/
package com.letao.rest.pojo;

import java.util.List;

/**
 * @ClassName CatResult
 * @Description TODO(商品目录的查询结果)
 * @author 廖永乐
 * @Date 2017年4月8日 上午10:26:33
 * @version 1.0.0
 */
public class CatResult {

    private List<?> data;

    
    /**
     * @return the data
     */
    public List<?> getData() {
        return data;
    }

    
    /**
     * @param data the data to set
     */
    public void setData(List<?> data) {
        this.data = data;
    }
}
