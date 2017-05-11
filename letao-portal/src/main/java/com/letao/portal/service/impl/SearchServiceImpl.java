/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     com.letao.portal.service.impl
 *
 *    Filename:    SearchServiceImpl.java
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
 *    Create at:   2017年5月7日 下午9:12:53
 *
 *    Revision:
 *
 *    2017年5月7日 下午9:12:53
 *        - first revision
 *
 *****************************************************************/
package com.letao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.letao.common.pojo.LetaoResult;
import com.letao.common.pojo.SearchResult;
import com.letao.common.utils.HttpClientUtil;
import com.letao.portal.service.SearchService;


/**
 * @ClassName SearchServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 廖永乐
 * @Date 2017年5月7日 下午9:12:53
 * @version 1.0.0
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Value("${SEARCH_BASE_URL}")
    private String  SEARCH_BASE_URL;
    
    /* (非 Javadoc)
     * Description:
     * @see com.letao.portal.service.SearchService#search(java.lang.String, int)
     */
    @Override
    public SearchResult search(String queryString, int page) {
        //设置参数
        Map<String,String> param =new HashMap<String, String>();
        param.put("q", queryString);
        param.put("page", page+"");
        try {
            //调用服务
            String resultString = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
            //将json字符串转为searchResult
            LetaoResult result=LetaoResult.formatToPojo(resultString, SearchResult.class);
            if(result.getStatus()==200){
                SearchResult searchResult=(SearchResult) result.getData();
                return searchResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
