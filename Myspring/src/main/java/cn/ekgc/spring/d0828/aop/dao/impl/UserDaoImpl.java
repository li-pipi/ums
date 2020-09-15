package cn.ekgc.spring.d0828.aop.dao.impl;

import cn.ekgc.spring.d0828.ioc.dao.UserDao;

import java.util.Date;

public class UserDaoImpl implements UserDao {

	@Override
	public void saveUser() throws Exception {
		System.out.println("UserDao saveUser()... : " + new Date());
	}
}
