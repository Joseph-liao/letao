/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.common.pojo
 *
 *    Filename:    EUDataGridResult.java
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
 *    Create at:   2017年3月26日 下午2:49:13
 *
 *    Revision:
 *
 *    2017年3月26日 下午2:49:13
 *        - first revision
 *
 *****************************************************************/
package com.letao.common.pojo;

import java.util.List;

/**
 * @ClassName EUDataGridResult
 * @Description TODO(EasyUI要求的返回JSON数据的Bean)
 * @author 廖永乐
 * @Date 2017年3月26日 下午2:49:13
 * @version 1.0.0
 */
public class EUDataGridResult {

    public long total;
    public List<?> rows;
    
    /**
     * @return the total
     */
    public long getTotal() {
        return total;
    }
    
    /**
     * @param total the total to set
     */
    public void setTotal(long total) {
        this.total = total;
    }
    
    /**
     * @return the rows
     */
    public List<?> getRows() {
        return rows;
    }
    
    /**
     * @param rows the rows to set
     */
    public void setRows(List<?> rows) {
        this.rows = rows;
    }
    
    
    
    
}
