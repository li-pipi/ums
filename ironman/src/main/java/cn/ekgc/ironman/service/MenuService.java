package cn.ekgc.ironman.service;

import cn.ekgc.ironman.base.pojo.vo.Node;
import cn.ekgc.ironman.pojo.entity.Menu;
import cn.ekgc.ironman.pojo.entity.Role;

import java.util.List;

/**
 * <b>菜单模块业务层接口</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public interface MenuService {
	/**
	 * <b>根据角色信息获得首页面菜单列表</b>
	 * @param role
	 * @return
	 */
	List<Menu> getIndexMenuList(Role role) throws Exception;

	/**
	 * <b>根据角色授权Node集合</b>
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	List<Node> getNodeListForAuthc(Long roleId) throws Exception;
}
