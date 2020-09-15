package cn.ekgc.ironman.util;

import cn.ekgc.ironman.pojo.entity.User;
import cn.ekgc.ironman.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * <b>Shiro 认证域工具类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	/**
	 *<b>Shiro 授权方法</b>
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * <b>Shiro 认证方法</b>
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		//本质上负责登录过程
		//将AuthenticationToken 强制类转换为UsernamePasswordToken
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		//通过UsernamePasswordToken 获得用户登录所提供的 Cellphone 和 password
		String cellphone = token.getUsername();
		//获得登陆密码
		char[] passwordChars = token.getPassword();
		//校验用户所提交的手机号码和登陆密码有效
		if (ValidateUtil.checkCellphone(cellphone) && passwordChars != null
				&& ValidateUtil.checkPassword(new String(passwordChars))) {
			try {
				//此时用户提供的手机号码和密码有效，通过手机号码查询用户信息
				User user = userService.getUserByCellphone(cellphone);
				//判断该用户是否存在
				if (user != null && ConstanUtil.SYS_STATUS_ENABLE.equals(user.getStatus())) {
					//通过Shiro 比较用户名和密码是否相同
					String password = MD5Util.encrypt(new String(passwordChars));
					//将加密之后的密码重新设定到UsernamePasswordToken中
					token.setPassword(password.toCharArray());
					//默认用户登录成功，绑定HTTPSession
					session.setAttribute("user", user);
					SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
							user.getCellphone(), user.getPassword(), getName());
					return info;
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
