package cn.ekgc.spring.d0828.ioc;


import cn.ekgc.spring.d0828.ioc.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDemo01 {
	public static void main(String[] args) throws Exception {
		// 创建业务层对象
//		UserDao userDao = new UserDaoImpl();
//		UserServiceImpl userService = new UserServiceImpl();
//		userService.setUserDao(userDao);
//		userService.saveUser();

		// 创建 ClassPathXmlApplicationContext 对象
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("d0828/ioc.xml");
		// 通过 bean id 获得对应的对象
		UserService userService = (UserService) context.getBean("userService");
		userService.saveUser();
	}
}
