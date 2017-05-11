package com.letao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.letao.common.pojo.EUDataGridResult;
import com.letao.common.pojo.LetaoResult;
import com.letao.common.utils.IDUtils;
import com.letao.mapper.TbItemDescMapper;
import com.letao.mapper.TbItemMapper;
import com.letao.mapper.TbItemParamItemMapper;
import com.letao.pojo.TbItem;
import com.letao.pojo.TbItemDesc;
import com.letao.pojo.TbItemDescExample;
import com.letao.pojo.TbItemExample;
import com.letao.pojo.TbItemExample.Criteria;
import com.letao.pojo.TbItemParamItem;
import com.letao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	@Autowired
	private TbItemDescMapper itemDescMapper;
	
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		// TODO Auto-generated method stub
		//itemMapper.selectByPrimaryKey(ItemId);
		
		//根据查询条件查询
		TbItemExample example =new TbItemExample();
		Criteria criteria =example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null&& list.size()>0){
			TbItem tbItem = list.get(0);
			return tbItem;
		}
		
		return null;
	}

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemService#getItemList(int, int)
     */
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        // TODO Auto-generated method stub
        //查询商品列表
        TbItemExample example=new TbItemExample();
        //开始分页
        PageHelper.startPage(page, rows);
        //创建返回值对象，并为其属性赋值
        EUDataGridResult result =new EUDataGridResult();
        List<TbItem> list = itemMapper.selectByExample(example);
        result.setRows(list);
        //设置记录总数量
        PageInfo<TbItem> pageInfo =new PageInfo<>(list);
        long total = pageInfo.getTotal();
        result.setTotal(total);
        
        return result;
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemService#createItem(com.letao.pojo.TbItem)
     */
    @Override
    public LetaoResult createItem(TbItem item,String desc,String itemParams) throws Exception {
        Date date = new Date();
        //生成商品ID
        long itemId = IDUtils.genItemId();
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(date);
        item.setUpdated(date);
        itemMapper.insert(item);
        
        //添加商品描述
        //创建TbItemDesc对象
        TbItemDesc itemDesc = new TbItemDesc();
        //获得一个商品id
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(date);
        itemDesc.setUpdated(date);
        //插入数据
        itemDescMapper.insert(itemDesc);
        
        LetaoResult result = insertItemParamItem(itemId, itemParams);
        if(result.getStatus()!=200){
            throw new Exception();
        }
        
        //返回自定义响应格式
        return LetaoResult.ok();
        
        
    }
    
    public LetaoResult insertItemParamItem(Long itemId, String itemParams) {
        //创建一个pojo
        TbItemParamItem itemParamItem = new TbItemParamItem();
        itemParamItem.setItemId(itemId);
        itemParamItem.setParamData(itemParams);
        itemParamItem.setCreated(new Date());
        itemParamItem.setUpdated(new Date());
        //向表中插入数据
        itemParamItemMapper.insert(itemParamItem);
        
        return LetaoResult.ok();
        
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemService#queryDescByItemId(java.lang.Long)
     */
    @Override
    public LetaoResult queryDescByItemId(Long itemId) {
        // TODO Auto-generated method stub
       TbItemDescExample example =new TbItemDescExample();
       com.letao.pojo.TbItemDescExample.Criteria criteria = example.createCriteria();
       criteria.andItemIdEqualTo(itemId);
       List<TbItemDesc> list = itemDescMapper.selectByExampleWithBLOBs(example);
       if(list!=null&&list.size()>0){
           return LetaoResult.ok(list.get(0));
       }
       return LetaoResult.ok();
        
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemService#instockItemByItemId(java.lang.Long)
     */
    @Override
    public int instockItemByItemId(Long itemId,int status) {
        // TODO Auto-generated method stub
        TbItemExample example =new TbItemExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        TbItem item = list.get(0);
        item.setStatus((byte) status);
        int key = itemMapper.updateByPrimaryKey(item);
        return key;
  
    }

    /* (非 Javadoc)
     * Description:
     * @see com.letao.service.ItemService#updateItemsStatusToInstock(java.lang.Long[])
     */
    @Override
    public LetaoResult updateItemsStatusToInstock(Long[] itemIds,int status) {
        // TODO Auto-generated method stub
        for (int i = 0; i < itemIds.length; i++) {
            instockItemByItemId(itemIds[i],status);
        }        
        
        return LetaoResult.ok();
    }


}
