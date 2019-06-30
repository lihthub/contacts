package com.example.contacts.dao;

import java.util.List;

import com.example.contacts.entity.Linkman;
import com.example.contacts.manager.dao.BaseDao;

public interface LinkmanDao extends BaseDao<Linkman, Long> {

	public void findByIdAndUser_id(Long id, Long userId);
	
	public List<Linkman> findByNameLike(String name);
	
}
