package cn.ekgc.ironman.service;

import cn.ekgc.ironman.base.pojo.vo.Page;
import cn.ekgc.ironman.pojo.entity.Role;

import java.util.List;

/**
 * <b>角色模块业务层接口</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */

public interface RoleService {
	/**
	 * <b>分页查询对象信息</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	Page<Role> getPage(Page<Role> page) throws Exception;

	/**
	 * <b>修改信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	boolean update(Role role) throws Exception;

	/**
	 * <b>根据角色名称查询对象</b>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Role getByName(String name) throws Exception;

	/**
	 * <b>保存对象</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	boolean save(Role role) throws Exception;

	/**
	 *<b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Role getById(Long id) throws Exception;

	/**
	 * <b>角色授权</b>
	 * @param id
	 * @param menuIdList
	 * @return
	 * @throws Exception
	 */
	boolean authcRole(Long id, List<Long> menuIdList) throws Exception;
}
