package com.example.contacts.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.contacts.dao.LinkmanDao;
import com.example.contacts.entity.Linkman;

@Service
public class LinkmanService {
	@Resource
	private LinkmanDao linkmanDao;
	
	public Linkman save(Linkman linkman) {
		return linkmanDao.save(linkman);
	}
	
	public void delete(Long id) {
		linkmanDao.delete(id);
	}
	
	public List<Linkman> findAll(String name) {
		if (StringUtils.isEmpty(name)) {
			return linkmanDao.findAll();
		}
		return linkmanDao.findByNameLike("%" + name + "%");
	}

	public Linkman findOne(Long id) {
		return linkmanDao.findOne(id);
	}
	
}
