package cn.ekgc.spring.d0828.ioc.dao.impl;



import cn.ekgc.spring.d0828.ioc.dao.UserDao;

import java.util.Date;

public class UserDaoMySQLImpl implements UserDao {
	@Override
	public void saveUser() throws Exception {
		System.out.println("使用 MySQL 数据库存储 User : " + new Date());
	}
}

