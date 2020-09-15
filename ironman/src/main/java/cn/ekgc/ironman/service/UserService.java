package cn.ekgc.ironman.service;

import cn.ekgc.ironman.base.pojo.vo.Page;
import cn.ekgc.ironman.pojo.entity.Role;
import cn.ekgc.ironman.pojo.entity.User;

/**
 * <b>用户模块业务层接口</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public interface UserService {
	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	User getUserByCellphone(String cellphone) throws Exception;

	/**
	 * <b>分页查询对象信息</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<User> getPage(Page<User> page) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean update(User user) throws Exception;
}
