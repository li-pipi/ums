package cn.ekgc.ironman.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class ConstanUtil {
	private static Properties props = new Properties();

	static {
		try {
			//加载配置文件
			props.load(ConstanUtil.class.getClassLoader().getResourceAsStream("props/ironman.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页状态：当前页码</b>
	 */
	public static Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页状态：每页显示数量</b>
	 */
	public static Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));

	/**
	 * <b>系统状态：启用</b>
	 */
	public static Integer SYS_STATUS_ENABLE = Integer.parseInt(props.getProperty("sys.status.enable"));

	/**
	 * <b>系统状态：禁用</b>
	 */
	public static Integer SYS_STATUS_DISABLE = Integer.parseInt(props.getProperty("sys.status.disable"));
}
