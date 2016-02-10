package com.site.code.controllers;

import com.site.code.dao.ListDataDAO;
import com.site.code.entity.ListData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@RequestMapping(value="/rest")
public class RestController {


	@Inject
	private ListDataDAO listDataDAO;
	
	@RequestMapping(method=RequestMethod.GET, value="/book/{dataId}")
	public @ResponseBody
	ListData getListData(@PathVariable(value="dataId") long dataId, Model model) {

		ListData listData = listDataDAO.getListDataById(dataId);
		return listData;

	}
}
