package org.wyf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.wyf.mapper.TbItemMapper;
import org.wyf.pojo.TbItem;
import org.wyf.pojo.TbItemExample;
import org.wyf.service.TbItemService;
import org.wyf.utils.EasyUIDataGridResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TbItemSerivceImpl implements TbItemService {

	@Resource
	private TbItemMapper tbItemMapper;
	
	@Override
	public EasyUIDataGridResult getTbItemList(Integer page, Integer rows) {
		  	PageHelper.startPage(page, rows);
		   TbItemExample example = new TbItemExample();
		   List<TbItem> list =tbItemMapper.selectByExample(example);
		       for(int i = 0;i<list.size();i++) {
			     System.out.println(list.get(i).toString());
		   }
		    PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		    long total = pageInfo.getTotal();
		    EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult(total,list);
		   return easyUIDataGridResult;
	}
}
