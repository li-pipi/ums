package cn.ekgc.ssm.dao;

import cn.ekgc.ssm.pojo.entity.User;

import java.util.List;

public interface UserDao {
	/**
	 * <b>查询用户信息列表</b>
	 * @return
	 * @throws Exception
	 */
	List<User> findUserList() throws Exception;

	/**
	 * <b>保存用户信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Integer saveUser(User user) throws Exception;
}
