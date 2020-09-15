package cn.ekgc.ironman.service.impl;

import cn.ekgc.ironman.base.pojo.vo.Page;
import com.github.pagehelper.PageHelper;
import cn.ekgc.ironman.dao.RoleDao;
import com.github.pagehelper.PageInfo;
import cn.ekgc.ironman.pojo.entity.Role;
import cn.ekgc.ironman.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>角色模块业务层接口实现类</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	/**
	 * <b>分页查询对象信息</b>
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<Role> getPage(Page<Role> page) throws Exception {
		// 如果需要在查询列表的时候进行分页查询，那么在进行查询列表代码之前，开启分页过滤器
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		// 开启分页过滤器之后，以下第一行列表查询，PageHelper 将直接采用分页查询
		List<Role> list = roleDao.findListByQuery(new Role());
		// 在获得分页列表之后，为了能够更好的获得分页其他信息
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		// 从 PageInfo 中提取数据
		page.setList(pageInfo.getList());
		page.setTotalCount(pageInfo.getTotal());
		page.setTotalPage(pageInfo.getPages());
		return page;
	}

	/**
	 * <b>修改信息</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(Role role) throws Exception {
		Integer count = roleDao.update(role);
		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>根据角色名称查询对象</b>
	 * @param name
	 * @return
	 * @throws Exception
	 */
	@Override
	public Role getByName(String name) throws Exception {
		//封装查询对象
		Role query = new Role();
		query.setName(name);
		//使用查询对象进行列表查询
		List<Role> list = roleDao.findListByQuery(query);
		//判断结果
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * <b>保存对象</b>
	 * @param role
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(Role role) throws Exception {
		Integer count = roleDao.save(role);
		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 *<b>根据主键查询信息</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public Role getById(Long id) throws Exception {
		//封装查询对象
		Role query = new Role();
		query.setId(id);
		//使用查询对象进行列表查询
		List<Role> list = roleDao.findListByQuery(query);
		//判断结果
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * <b>角色授权</b>
	 * @param id
	 * @param menuIdList
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean authcRole(Long id, List<Long> menuIdList) throws Exception {
		//根据角色删除旧权限
		roleDao.deleteRoleMenuById(id);
		//将新的权限插入到中间表
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("roleId",id);
		for (Long menuId : menuIdList) {
			params.put("menuId", menuId);
			roleDao.saveRoleMenu(params);
		}
		return true;
	}
}
