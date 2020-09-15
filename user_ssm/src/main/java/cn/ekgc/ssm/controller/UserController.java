package cn.ekgc.ssm.controller;

import cn.ekgc.ssm.pojo.entity.User;
import cn.ekgc.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller("userController")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;

	/**
	 * <b>获得用户列表</b>
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/list")
	public String queryUserList(ModelMap map) throws Exception {
		// 通过业务层查询用户信息列表
		List<User> userList = userService.getUserList();
		// 将获得的列表绑定到 ModelMap 中进行转发
		map.put("userList", userList);
		// 返回转发页面路径
		return "user_index";
	}

	/**
	 * <b>转发到添加页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/save")
	public String forwardSavePage() throws Exception {
		return "user_save";
	}

	/**
	 * <b>保存用户</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public String saveUser(User user) throws Exception {
		boolean flag = userService.saveUser(user);
		if (flag) {
			// 保存成功，重定向到列表页面
			return "redirect:list";
		} else {
			// 保存失败，重定向到添加页面
			return "redirect:save";
		}
	}
}
