package cn.ekgc.ssm.service;


import cn.ekgc.ssm.pojo.entity.User;

import java.util.List;
public interface UserService {
	/**
	 * <b>获得用户信息列表页面</b>
	 * @return
	 * @throws Exception
	 */
	List<User> getUserList() throws Exception;

	/**
	 * <b>保存用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean saveUser(User user) throws Exception;
}
