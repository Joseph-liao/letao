package com.letao.service;

import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.pojo.TbItem;


/**
 * 
 * @ClassName ItemService
 * @Description TODO(商品service)
 * @author 廖永乐
 * @Date 2017年3月30日 下午4:41:21
 * @version 1.0.0
 */
public interface ItemService {

	/**
	 * 根据ID查找Item
	 * */	
	public TbItem getItemById(long ItemId);
	
	/**
	 * 
	 * @Description (得到分页查询的商品数据信息)
	 * @param page
	 * @param rows
	 * @return
	 */
	public EUDataGridResult getItemList(int page, int rows);
	
	/**
	 * 
	 * @Description (创建商品)
	 * @param item
	 */
	public LetaoResult createItem(TbItem item,String desc,String itemParams) throws Exception;
	
	/**
	 * 
	 * @Description (根据商品Id查找商品描述)
	 * @param itemId
	 * @return
	 */
	public LetaoResult queryDescByItemId(Long itemId);
	
	/**
	 * 
	 * @Description (根据商品改变商品状态为下架)
	 * @param itemId
	 * @return
	 */
	public int instockItemByItemId(Long itemId,int status);
	
	/**
	 * 
	 * @Description (批量改变商品状态为下架)
	 * @param itemIds
	 * @return
	 */
	public LetaoResult updateItemsStatusToInstock(Long[] itemIds,int status);
	
	

}
