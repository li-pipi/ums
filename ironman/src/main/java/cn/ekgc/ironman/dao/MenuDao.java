package cn.ekgc.ironman.dao;

import cn.ekgc.ironman.pojo.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * <b>菜单模块数据持久层接口</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public interface MenuDao {

	/**
	 * <b>根据角色信息获取菜单列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListForIndex(Map<String, Object> query) throws Exception;

	/**
	 * <b>查询菜单列表</b>
	 * @return
	 * @throws Exception
	 */
	List<Menu> findMenuListByQuery() throws Exception;

}
