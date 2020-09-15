package cn.ekgc.ironman.dao;


import cn.ekgc.ironman.pojo.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * <b>角色模块数据持久层接口</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public interface RoleDao {

	/**
	 * <b>根据查询对象查询信息列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Role> findListByQuery(Role query) throws Exception;

	/**
	 * <b>保存对象信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(Role entity) throws Exception;

	/**
	 * <b>修改对象信息</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(Role entity) throws Exception;

	/**
	 * <b>根据角色删除中间表数据</b>
	 * @param id
	 * @throws Exception
	 */
	void deleteRoleMenuById(Long id) throws Exception;

	/**
	 * <b></b>
	 * @param params
	 */
	void saveRoleMenu(Map<String, Long> params);
}
