package cn.ekgc.spring.d0828.ioc.service.impl;

import cn.ekgc.spring.d0828.ioc.dao.UserDao;

import cn.ekgc.spring.d0828.ioc.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	@Override
	public void saveUser() throws Exception {
		userDao.saveUser();
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
