package cn.ekgc.spring.d0828.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class UserDemo02 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("d0828/ioc.xml");
		User user = (User) context.getBean("user");
		user.show();
	}
}
