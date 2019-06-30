package pers.contacts.dao;

import java.util.List;

import pers.contacts.core.dao.BaseDao;
import pers.contacts.entity.Linkman;

public interface LinkmanDao extends BaseDao<Linkman, Long> {

	public void findByIdAndUser_id(Long id, Long userId);
	
	public List<Linkman> findByNameLike(String name);
	
}
