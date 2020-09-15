package cn.ekgc.ssm.controller;

import cn.ekgc.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("userController")

public class UserController {
	@Autowired
	private UserService userService;
}
