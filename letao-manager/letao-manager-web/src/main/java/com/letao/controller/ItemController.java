package com.letao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbItem;
import com.letao.service.ItemService;

/**
 * @ClassName ItemController
 * @Description TODO(ItemController)
 * @author 廖永乐
 * @Date 2017年3月24日 上午8:41:48
 * @version 1.0.0
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 
	 * @Description (根据ItemId查找商品Controller)
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getTbItemById(@PathVariable Long itemId){
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	/**
	 * 
	 * @Description (查找商品Controller)
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(Integer page, Integer rows) {
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }
	
	/**
	 * 
	 * @Description (创建商品Controller)
	 * @param item
	 * @param desc
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public LetaoResult createItem(TbItem item,String desc,String itemParams) throws Exception{
	    LetaoResult result = itemService.createItem(item,desc,itemParams); 
        return result;
	}
	
	@RequestMapping(value="/rest/page/item-edit")
	public String editItem(HttpServletRequest request){
	       Map<String, String[]> params = request.getParameterMap();  
	        String queryString = "";  
	        for (String key : params.keySet()) {  
	            String[] values = params.get(key);  
	            for (int i = 0; i < values.length; i++) {  
	                String value = values[i];  
	                queryString += key + "=" + value + "&";  
	            }  
	        } 
	    return "item-edit";
	}
	
	/**
	 * 
	 * @Description (根据商品ID查找商品信息并回显)
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/rest/item/query/item/desc/{itemId}")
	@ResponseBody
	public LetaoResult queryItemDescByItemId(@PathVariable Long itemId){
	    LetaoResult result = itemService.queryDescByItemId(itemId);
	    return result;    
	}
	
	/**
	 * 
	 * @Description (批量改变商品状态为下架)
	 * @param request
	 * @return
	 */
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public LetaoResult instockItem(HttpServletRequest request){
/*	    Enumeration em = request.getParameterNames();
	    while (em.hasMoreElements()) {
	       String name = (String) em.nextElement();
	       String value = request.getParameter(name);
	       System.out.println(name);
	       System.out.println(value);
	   }*/
	    String ids = request.getParameter("ids");
	    String[] split = ids.split(",");
	    List<Long> LongId=new ArrayList<Long>();
	    for (String string : split) {
            long id = Long.parseLong(string);
            LongId.add(id);
        }   
	    itemService.updateItemsStatusToInstock(LongId.toArray(new Long[LongId.size()]),2);
	    return LetaoResult.ok();
	}
	
	/**
	 * 
	 * @Description (批量改变商品状态为上架)
	 * @param request
	 * @return
	 */
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public LetaoResult reshelf(HttpServletRequest request){
	       String ids = request.getParameter("ids");
	        String[] split = ids.split(",");
	        List<Long> LongId=new ArrayList<Long>();
	        for (String string : split) {
	            long id = Long.parseLong(string);
	            LongId.add(id);
	        }   
	        itemService.updateItemsStatusToInstock(LongId.toArray(new Long[LongId.size()]),1);
	        return LetaoResult.ok();
	}
	

	
}
