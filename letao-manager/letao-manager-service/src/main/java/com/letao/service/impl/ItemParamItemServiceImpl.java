/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.service.impl
 *
 *    Filename:    ItemParamItemServiceImpl.java
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
 *    Create at:   2017年4月1日 上午11:00:12
 *
 *    Revision:
 *
 *    2017年4月1日 上午11:00:12
 *        - first revision
 *
 *****************************************************************/
package com.letao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.common.utils.JsonUtils;
import com.letao.mapper.TbItemParamItemMapper;
import com.letao.pojo.TbItem;
import com.letao.pojo.TbItemParamItem;
import com.letao.pojo.TbItemParamItemExample;
import com.letao.pojo.TbItemParamItemExample.Criteria;
import com.letao.service.ItemParamItemService;


/**
 * @ClassName ItemParamItemServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年4月1日 上午11:00:12
 * @version 1.0.0
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemParamItemService#getItemParamByItemId(java.lang.Long)
     */
    @Override
    public String getItemParamByItemId(Long itemId) {
        //根据商品id查询规格参数
        TbItemParamItemExample example = new TbItemParamItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        //执行查询
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list == null || list.size() == 0) {
            return "";
        }
        //取规格参数信息
        TbItemParamItem itemParamItem = list.get(0);
        String paramData = itemParamItem.getParamData();
        //生成html
        // 把规格参数json数据转换成java对象
        List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for(Map m1:jsonList) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
            sb.append("        </tr>\n");
            List<Map> list2 = (List<Map>) m1.get("params");
            for(Map m2:list2) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
                sb.append("            <td>"+m2.get("v")+"</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        return sb.toString();
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemParamItemService#queryItemParamByItemId(java.lang.Long)
     */
    @Override
    public LetaoResult queryItemParamByItemId(Long itemId) {
        TbItemParamItemExample example =new TbItemParamItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
        if(list!=null&&list.size()>0){
            TbItemParamItem itemParamItem = list.get(0);
            LetaoResult result = LetaoResult.ok(itemParamItem);
            return result;
        }
        return LetaoResult.ok();
    }


}
