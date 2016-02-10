package com.site.code.dao;

import java.util.List;

import com.site.code.entity.ListData;

public interface ListDataDAO {
	
	List<ListData> getAllListData();
	
	List<ListData> getListDataByTitle(String title);
	
	ListData getListDataById(Long id);
}
