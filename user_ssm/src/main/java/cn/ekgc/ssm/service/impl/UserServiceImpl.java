package cn.ekgc.ssm.service.impl;

import cn.ekgc.ssm.dao.UserDao;
import cn.ekgc.ssm.pojo.entity.User;
import cn.ekgc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>获得用户信息列表页面</b>
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<User> getUserList() throws Exception {
		// 调用数据持久层查询信息列表
		List<User> userList = userDao.findUserList();
		return userList;
	}

	/**
	 * <b>保存用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean saveUser(User user) throws Exception {
		// 数据持久层保存用户
		Integer count = userDao.saveUser(user);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
