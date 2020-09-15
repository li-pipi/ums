package cn.ekgc.spring.d0828.aop.log;
import java.util.Date;
public class UserLogger {
	public void saveUserBefor() {
		System.out.println("UserDao 开始执行 saveUser()... : " + new Date());
	}

	public void saveUserAfter() {
		System.out.println("UserDao 保存 User 结束... : " + new Date());
	}
}
