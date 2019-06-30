package com.example.contacts.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.contacts.dao.UserDao;
import com.example.contacts.entity.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;

	public User findByPhone(String phone) {
		return userDao.findByPhone(phone);
	}
	
	public User saveUser(User user) {
		return userDao.save(user);
	}

}
