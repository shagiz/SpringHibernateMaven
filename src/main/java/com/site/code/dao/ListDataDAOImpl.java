package com.site.code.dao;

import java.util.List;

import com.site.code.entity.ListData;
import org.springframework.orm.jpa.support.JpaDaoSupport;

public class ListDataDAOImpl extends JpaDaoSupport implements ListDataDAO {

	public List<ListData> getAllListData() {
		return getJpaTemplate().find("select b from ListData b");
	}

	public List<ListData> getListDataByTitle(String title) {
		return getJpaTemplate().find("select b from ListData b where b.title=?1", title);
	}

	public ListData getListDataById(Long id) {
		return getJpaTemplate().find(ListData.class, id);
	}

}
