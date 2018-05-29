package pers.contacts.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.contacts.dao.UserDao;
import pers.contacts.entity.User;

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
