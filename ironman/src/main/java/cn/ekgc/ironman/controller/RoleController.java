package cn.ekgc.ironman.controller;

import cn.ekgc.ironman.base.pojo.vo.Page;
import cn.ekgc.ironman.base.pojo.vo.ResponseVO;
import cn.ekgc.ironman.pojo.entity.Role;
import cn.ekgc.ironman.base.controller.Basecontroller;
import cn.ekgc.ironman.service.RoleService;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>角色模块控制器</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Controller("roleController")
@RequestMapping("/role")
public class RoleController extends Basecontroller {
	@Autowired
	private RoleService roleService;
	/**
	 * <b>转发角色首页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/index")
	public String index() throws Exception {
		return "role/role_index";
	}
	/**
	 * <b>分页查询对象信息</b>
	 * @param pageNum
	 * @param pageSize
	 * @param draw
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	@ResponseBody
	public ResponseVO queryPage(Integer pageNum, Integer pageSize, Integer draw) throws Exception {
		// 使用 pageNum、pageSize 封装 Page 对象
		Page<Role> page = new Page<Role>(pageNum, pageSize, draw);
		// 使用分页对象进行分页查询
		page = roleService.getPage(page);
		// 返回信息
		return ResponseVO.success(page);
	}

	/**
	 * <b>转发到添加页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/save")
	public String forwardSavePage() throws Exception{
		return "role/role_save";
	}


	/**
	 * <b>校验角色名称</b>
	 * @param id
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/validate/name")
	@ResponseBody
	public boolean validateName(Long id, String name) throws Exception {
		//通过角色名称获得角色对象
		Role role = roleService.getByName(name);
		//联合使用所传递的主键判断该角色名称是否被占用
		if (role == null || (role != null && role.getId().equals(id))) {
			//此时该角色名称可以使用
			return true;
		}
		return false;
	}

	@PostMapping("/save")
	@ResponseBody
	public ResponseVO save(Role role) throws Exception {
		//校验该角色名称是否已被使用
		if (validateName(role.getId(), role.getName())) {
			//未被使用，则进行保存
			boolean flag = roleService.save(role);
			if (flag) {
				return ResponseVO.success("角色保存成功！");
			}else {
				return ResponseVO.error("角色保存失败！");
			}
		}
		return ResponseVO.error("该角色名称已被占用");
	}

	/**
	 * <b>加载修改界面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/update/{id}")
	public String forwardUpdatePage(@PathVariable("id") Long id) throws Exception {
		return "role/role_update";
	}

	/**
	 * <b>保存信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@ResponseBody
	public ResponseVO update(Role role) throws Exception {
		if(role.getName() != null) {
			//校验该角色名称是否已被使用
			if (validateName(role.getId(), role.getName())) {
				//未被使用，则进行保存
				boolean flag = roleService.update(role);
				if (flag) {
					return ResponseVO.success("角色保存成功！");
				}else {
					return ResponseVO.error("角色保存失败！");
				}
			}
			return ResponseVO.error("该角色名称已被占用");
		}else {
			// 修改状态
			boolean flag = roleService.update(role);
			if (flag) {
				// 修改成功
				return ResponseVO.success("杀两个陈仁豪祭天");
			}
			return ResponseVO.error("杀一个陈仁豪祭天");
		}
	}

	/**
	 * <b>根据主键查询对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseVO queryById(@PathVariable("id") Long id) throws Exception {
		return ResponseVO.success(roleService.getById(id));
	}

	/**
	 * <b>加载角色授权页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/authc/{id}")
	public String forwardAuthcPage(@PathVariable("id") Long id) throws Exception {
		return "role/role_authc";
	}

	/**
	 * <b>角色授权</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/authc/{id}")
	@ResponseBody
	public ResponseVO forwardAuthcPage(@PathVariable("id") Long id, String nodeIdStrs) throws Exception {
		//截取 nodeIdStrs 获得菜单注释集合
		List<Long> menuIdList = new ArrayList<Long>();
		String[] nodeIds = nodeIdStrs.split("-");
		for (String nodeId : nodeIds) {
			Long menuId = Long.parseLong(nodeId);
			menuIdList.add(menuId);
		}
		//进行数据授权
		boolean flag = roleService.authcRole(id,menuIdList);
		if (flag) {
			return ResponseVO.success("授权成功");
		}
		return ResponseVO.error("授权失败");
	}
}
