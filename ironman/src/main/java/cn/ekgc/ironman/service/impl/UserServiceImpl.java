package cn.ekgc.ironman.service.impl;

import cn.ekgc.ironman.base.pojo.vo.Page;
import cn.ekgc.ironman.dao.UserDao;
import cn.ekgc.ironman.pojo.entity.User;
import cn.ekgc.ironman.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>用户模块业务层接口实现类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * <b>根据手机号码查询用户信息</b>
	 * @param cellphone
	 * @return
	 * @throws Exception
	 */
	@Override
	public User getUserByCellphone(String cellphone) throws Exception {
		//创建 User 查询对象
		User query = new User();
		//设置查询参数
		query.setCellphone(cellphone);
		//进行查询，获得列表
		List<User> userList = userDao.findListByQuery(query);
		if (userList != null && userList.size() > 0) {
			//根据业务，使用手机号码查询，有且仅有一条数据
			System.out.println(userList.get(0));
			return userList.get(0);
		}
		return null;
	}

	/**
	 * <b>分页查询对象信息</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<User> getPage(Page<User> page) throws Exception{
		// 如果需要在查询列表的时候进行分页查询，那么在进行查询列表代码之前，开启分页过滤器
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		// 开启分页过滤器之后，以下第一行列表查询，PageHelper 将直接采用分页查询
		List<User> list = userDao.findListByQuery(new User());
		// 在获得分页列表之后，为了能够更好的获得分页其他信息
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		// 从 PageInfo 中提取数据
		page.setList(pageInfo.getList());
		page.setTotalCount(pageInfo.getTotal());
		page.setTotalPage(pageInfo.getPages());
		return page;

	}

	/**
	 * <b>修改信息</b>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(User user) throws Exception {
		Integer count = userDao.update(user);
		if (count > 0) {
			return true;
		}
		return false;
	}
}
