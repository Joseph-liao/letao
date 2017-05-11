/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service
 *
 *    Filename:    ItemParamService.java
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
 *    Create at:   2017年3月31日 下午3:57:14
 *
 *    Revision:
 *
 *    2017年3月31日 下午3:57:14
 *        - first revision
 *
 *****************************************************************/
package com.letao.service;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbItemParam;

/**
 * @ClassName ItemParamService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年3月31日 下午3:57:14
 * @version 1.0.0
 */
public interface ItemParamService {

    /**
     * 
     * @Description (根据商品类目得到商品类目规格组)
     * @param cid
     * @return
     */
    public LetaoResult getItemParamByCid(long cid);

    /**
     * @Description (插入商品类目规格参数)
     * @param itemParam
     * @return
     */
    public LetaoResult insertItemParam(TbItemParam itemParam);
    
    /**
     * 
     * @Description (得到商品规格参数列表)
     * @return
     */
    public EUDataGridResult getItemParamList(Integer page, Integer rows);
    
    /**
     * 
     * @Description (根据ID删除商品规格属性)
     * @param cId
     * @return
     */
    public int deleteItemParamById(Long cId);
    
    /**
     * 
     * @Description (批量删除选择的商品规格属性)
     * @param cIds
     * @return
     */
    public LetaoResult deleteItemParams(Long[] cIds);
    
    /**
     * 
     * @Description (根据商品规格熟悉ID查找商品)
     * @param id
     * @return
     */
    public String getParamDataById(Long id);
}
