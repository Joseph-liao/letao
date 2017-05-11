/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
 *
 *    Filename:    ItemParamServiceImpl.java
 *
 *    Description: TODO(鐢ㄤ竴鍙ヨ瘽鎻忚堪璇ユ枃浠跺仛浠�涔�)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     寤栨案涔�
 *
 *    @version:    1.0.0
 *
 *    Create at:   2017骞�3鏈�31鏃� 涓嬪崍3:59:34
 *
 *    Revision:
 *
 *    2017骞�3鏈�31鏃� 涓嬪崍3:59:34
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.mapper.TbItemParamMapper;
import com.letao.pojo.TbItemParam;
import com.letao.pojo.TbItemParamExample;
import com.letao.pojo.TbItemParamExample.Criteria;
import com.letao.service.ItemParamService;



/**
 * @ClassName ItemParamServiceImpl
 * @Description TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜绫荤殑浣滅敤)
 * @author 寤栨案涔�
 * @Date 2017骞�3鏈�31鏃� 涓嬪崍3:59:34
 * @version 1.0.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;
    
    @Override
    public LetaoResult getItemParamByCid(long cid) {
        TbItemParamExample example = new TbItemParamExample();
        Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        //鍒ゆ柇鏄惁鏌ヨ鍒扮粨鏋�
        if (list != null && list.size() > 0) {
            return LetaoResult.ok(list.get(0));
        } 
        return LetaoResult.ok();
    }
    
    @Override
    public LetaoResult insertItemParam(TbItemParam itemParam) {
        //琛ュ叏pojo
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        //鎻掑叆鍒拌鏍煎弬鏁版ā鏉胯〃
        itemParamMapper.insert(itemParam);
        return LetaoResult.ok();
    }

    /* (闈� Javadoc)
     * Description:
     * @see com.letao.service.ItemParamService#getItemParamList()
     */
    @Override
    public EUDataGridResult getItemParamList(Integer page, Integer rows) {
        // TODO Auto-generated method stub
        TbItemParamExample example =new TbItemParamExample();
        PageHelper.startPage(page, rows);
        EUDataGridResult result =new EUDataGridResult();
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        result.setRows(list);
        PageInfo<TbItemParam> pf =new PageInfo<>(list);
        result.setTotal(pf.getTotal());
        
        return result;
        
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemParamService#deleteItemParamById(java.lang.Long)
     */
    @Override
    public int deleteItemParamById(Long cId) {
        // TODO Auto-generated method stub
       TbItemParamExample example =new TbItemParamExample();
       Criteria criteria = example.createCriteria();
       criteria.andIdEqualTo(cId);
       int i = itemParamMapper.deleteByExample(example);
       return i;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemParamService#deleteItemParams(java.lang.Long[])
     */
    @Override
    public LetaoResult deleteItemParams(Long[] cIds) {
        // TODO Auto-generated method stub
        int i=0;
        for (Long cid : cIds) {
            i = deleteItemParamById(cid);
            if(i<1){
                return null;
            }
        }
        return LetaoResult.ok();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemParamService#getParamDataById(java.lang.Long)
     */
    @Override
    public String getParamDataById(Long id) {
        TbItemParamExample example=new TbItemParamExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
        if(list!=null&&list.size()>0){
             TbItemParam itemParam = list.get(0);
             return itemParam.getParamData();
        }
   
        return null;
    }

}
