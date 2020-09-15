package cn.ekgc.ironman.controller;

import cn.ekgc.ironman.base.controller.Basecontroller;
import cn.ekgc.ironman.pojo.entity.Menu;
import cn.ekgc.ironman.pojo.entity.Role;
import cn.ekgc.ironman.pojo.entity.User;
import cn.ekgc.ironman.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <b>首页面控制层</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Controller("indexController")
public class IndexController extends Basecontroller {

	@Autowired
	private MenuService menuService;
	/**
	 * <b>转发首页面</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/")
	public String index(ModelMap map) throws Exception {
		//在首页面根据当前登录用户获取该用户的操作功能
		//获取当前登录用户
		User user = (User) session.getAttribute("user");
			//用户已登录
			//根据当前登录用户获得对应的角色信息
			Role role = user.getRole();
			//根据角色信息获得对应的角色信息
			List<Menu> menuList = menuService.getIndexMenuList(role);
			//将菜单列表转发到页面
			map.put("menuList", menuList);
			return "index";
		}
	}

