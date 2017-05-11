/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.service.impl
 *
 *    Filename:    ItemServiceImpl.java
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
 *    Create at:   2017年5月10日 下午2:52:31
 *
 *    Revision:
 *
 *    2017年5月10日 下午2:52:31
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.common.utils.HttpClientUtil;
import com.letao.common.utils.JsonUtils;
import com.letao.pojo.TbItemDesc;
import com.letao.pojo.TbItemParamItem;
import com.letao.portal.pojo.ItemInfo;
import com.letao.portal.service.ItemService;


/**
 * @ClassName ItemServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月10日 下午2:52:31
 * @version 1.0.0
 */
@Service
public class ItemServiceImpl implements ItemService {
    
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    
    @Value("${ITME_INFO_URL}")
    private String ITME_INFO_URL;
    
    @Value("${ITEM_DESC_URL}")
    private String ITEM_DESC_URL;
    
    @Value("${ITEM_PARAM_URL}")
    private String ITEM_PARAM_URL;
    

    /* (非 Javadoc)
     * Description:
     * @see com.letao.portal.service.ItemService#getItemById(java.lang.Long)
     */
    @Override
    public ItemInfo getItemById(Long itemId) {
        try {
            //调用rest的服务查询商品基本信息
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
            if (!StringUtils.isBlank(json)) {
                LetaoResult taotaoResult = LetaoResult.formatToPojo(json, ItemInfo.class);
                if (taotaoResult.getStatus() == 200) {
                    ItemInfo item = (ItemInfo) taotaoResult.getData();
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.portal.service.ItemService#getItemDescById(java.lang.Long)
     */
    @Override
    public String getItemDescById(Long itemId) {
        try {
            //查询商品描述
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_DESC_URL + itemId);
            //转换成java对象
            LetaoResult taotaoResult = LetaoResult.formatToPojo(json, TbItemDesc.class);
            if (taotaoResult.getStatus() == 200) {
                TbItemDesc itemDesc = (TbItemDesc) taotaoResult.getData();
                //取商品描述信息
                String result = itemDesc.getItemDesc();
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.portal.service.ItemService#getItemParam(java.lang.Long)
     */
    @Override
    public String getItemParam(Long itemId) {
        try {
            String json = HttpClientUtil.doGet(REST_BASE_URL + ITEM_PARAM_URL + itemId);
            //把json转换成java对象
            LetaoResult taotaoResult = LetaoResult.formatToPojo(json, TbItemParamItem.class);
            if (taotaoResult.getStatus() == 200) {
                TbItemParamItem itemParamItem = (TbItemParamItem) taotaoResult.getData();
                String paramData = itemParamItem.getParamData();
                //生成html
                // 把规格参数json数据转换成java对象
                List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
                StringBuffer sb = new StringBuffer();
                sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
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
                //返回html片段
                return sb.toString();
            }
                 
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "";
    }
}
