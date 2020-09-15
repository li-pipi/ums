package cn.ekgc.ironman.pojo.entity;

import cn.ekgc.ironman.base.pojo.entity.BaseEntity;

import java.util.List;

/**
 * <b>角色信息实体</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class Role extends BaseEntity {
	private static final long serialVersionUID = 4518806815909044617L;
	private Long id;
	private String name;
	private List<Menu> menuList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
