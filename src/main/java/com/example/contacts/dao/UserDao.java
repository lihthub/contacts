package pers.contacts.dao;

import pers.contacts.core.dao.BaseDao;
import pers.contacts.entity.User;

public interface UserDao extends BaseDao<User, Long> {

	public User findByPhone(String phone);

}
