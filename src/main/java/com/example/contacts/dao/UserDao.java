package com.example.contacts.dao;

import com.example.contacts.entity.User;
import com.example.contacts.manager.dao.BaseDao;

public interface UserDao extends BaseDao<User, Long> {

	public User findByPhone(String phone);

}
