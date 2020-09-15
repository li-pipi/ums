package cn.ekgc.ironman.controller;

import cn.ekgc.ironman.base.controller.Basecontroller;
import cn.ekgc.ironman.base.pojo.vo.Node;
import cn.ekgc.ironman.base.pojo.vo.ResponseVO;
import cn.ekgc.ironman.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <b>菜单模块控制器</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Controller("menuController")
@RequestMapping("/menu")
public class MenuController extends Basecontroller {
	@Autowired
	private MenuService menuService;

	/**
	 * <b>根据角色查询授权 Node 集合</b>
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/authc/{roleId}")
	@ResponseBody
	public ResponseVO queryMenuListForAuthc(@PathVariable("roleId") Long roleId) throws Exception {
		//调用业务层使用角色查询Node集合
		List<Node> nodeList = menuService.getNodeListForAuthc(roleId);
		return ResponseVO.success(nodeList);
	}
}
