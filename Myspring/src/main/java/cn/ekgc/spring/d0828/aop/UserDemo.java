package cn.ekgc.spring.d0828.aop;


import cn.ekgc.spring.d0828.aop.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class UserDemo {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("d0828/aop.xml");
		UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.saveUser();
	}
}
