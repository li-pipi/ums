package cn.ekgc.ironman.service.impl;

import cn.ekgc.ironman.base.pojo.vo.Node;
import cn.ekgc.ironman.dao.MenuDao;
import cn.ekgc.ironman.pojo.entity.Menu;
import cn.ekgc.ironman.pojo.entity.Role;
import cn.ekgc.ironman.service.MenuService;
import cn.ekgc.ironman.util.ConstanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>菜单模块业务层接口实现类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	public MenuDao menuDao;
	/**
	 * <b>根据角色信息获得首页面菜单列表</b>
	 * @param role
	 * @return
	 */
	@Override
	public List<Menu> getIndexMenuList(Role role) throws Exception {
		Map<String, Object> query = new HashMap<String, Object>();
		//设定当前角色信息
		query.put("roleId", role.getId());
		//设置状态为启用状态
		query.put("status", ConstanUtil.SYS_STATUS_ENABLE);
		// 根据角色查询其所有的一级菜单
		query.put("pId", 0L);
		List<Menu> menuList = menuDao.findMenuListForIndex(query);
		// 循环一级菜单，查询对应的二级菜单
		for (Menu parent : menuList) {
			// 设定对应的二级菜单主键
			query.put("pId", parent.getId());
			List<Menu> childList = menuDao.findMenuListForIndex(query);
			// 将对应的二级菜单设定到一级菜单中
			parent.setChildList(childList);
		}
		return menuList;
	}

	/**
	 * <b>根据角色授权Node集合</b>
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Node> getNodeListForAuthc(Long roleId) throws Exception {
		List<Node> nodeList = new ArrayList<Node>();
		//获得所有Menu对象
		List<Menu> menuList = menuDao.findMenuListByQuery();
		//查询该角色所拥有的菜单集合
		Map<String, Object> query = new HashMap<String, Object>();
		//设定当前角色信息
		query.put("roleId",roleId);
		List<Menu> menuRoleList = menuDao.findMenuListForIndex(query);
		//循环menuList中的数据，切换到nodeList中
		for (Menu menu : menuList) {
			//创建Node对象
			Node node = new Node();
			node.setId(menu.getId());
			node.setName(menu.getText());
			if (menu.getParent() == null || menu.getParent().getId() == 0) {
				//此时的菜单为一级菜单
				node.setpId(0L);
				node.setOpen(true);
			}else {
				node.setpId(menu.getParent().getId());
			}
			//设定checke属性
			for (Menu roleMenu : menuRoleList) {
				//比较是否存在对应的menu
				if (menu.getId().equals(roleMenu.getId())) {
					//该菜单已经赋予角色
					node.setChecked(true);
					break;
				}
			}

			nodeList.add(node);
		}
		return nodeList;
	}
}
