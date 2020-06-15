package org.wyf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wyf.service.TbItemService;
import org.wyf.utils.EasyUIDataGridResult;
import org.wyf.utils.JsonUtils;

@Controller
@RequestMapping("/item")
	public class TbItemController {
		
		@Autowired
		public TbItemService tbItemService;
		
		@RequestMapping("/getItem")
		@ResponseBody
	    public String getTbItemList(@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows) {
			System.out.println("getTbItemList");
			EasyUIDataGridResult tbItemList = tbItemService.getTbItemList(page,rows);
			System.out.println("==========:" + tbItemList.toString());
			String objectToJson = JsonUtils.objectToJson(tbItemList);
			System.out.println("objectToJson:" + objectToJson);
	    	return objectToJson;
	    }
}

