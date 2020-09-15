package cn.ekgc.ironman.controller;

import cn.ekgc.ironman.base.controller.Basecontroller;

import cn.ekgc.ironman.base.pojo.vo.Page;
import cn.ekgc.ironman.base.pojo.vo.ResponseVO;
import cn.ekgc.ironman.pojo.entity.User;
import cn.ekgc.ironman.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <b>用户模块控制器</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController extends Basecontroller {
	@Autowired
	private UserService userService;

	/**
	 * <b>加载登陆界面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/login")
	public String forwardLoginPage() throws Exception{
		return "user/user_login";
	}
	/**
	 * <b>转发用户首页面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/index")
	public String index() throws Exception {
		return "user/user_index";
	}

	/**
	 * <b><认证失败时，调用的方法/b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/login")
	public String loginUser(String cellphone, String password) throws Exception {
		return "redirect:logout";
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
		Page<User> page = new Page<User>(pageNum, pageSize, draw);
		// 使用分页对象进行分页查询
		page = userService.getPage(page);
		// 返回信息
		return ResponseVO.success(page);
	}
	/**
	 * <b>保存信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@ResponseBody
	public ResponseVO update(User user) throws Exception {
		if (user.getCellphone() != null) {
			return ResponseVO.success();
		} else {
			// 修改状态
			boolean flag = userService.update(user);
			if (flag) {
				// 修改成功
				return ResponseVO.success("杀一窝陈仁豪祭天");
			}
			return ResponseVO.error("杀一个陈仁豪祭天");
		}
	}
}
