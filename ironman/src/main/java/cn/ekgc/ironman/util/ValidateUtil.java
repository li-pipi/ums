package cn.ekgc.ironman.util;

/**
 * <b>校验工具类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class ValidateUtil {
	//手机号码校验正则表达式
	public static final String CELLPHONE_REGEX = "^1[0-9]{10}$";

	/**
	 * <b>校验手机号码</b>
	 * @param cellphone
	 * @return
	 */
	public static boolean checkCellphone(String cellphone) {
		//校验该手机号码不能为null并且不能是空字符串
		if (cellphone != null && !"".equals(cellphone.trim())) {
			//校验格式是否正确
			return cellphone.matches(CELLPHONE_REGEX);
		}
		return false;
	}

	/**
	 * <b>校验密码</b>
	 * @param password
	 * @return
	 */
		public static boolean checkPassword(String password) {
			if (password != null && !"".equals(password)) {
				return true;
			}
			return false;
		}
}
