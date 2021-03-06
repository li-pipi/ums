package cn.ekgc.ironman.pojo.entity;

import cn.ekgc.ironman.base.pojo.entity.BaseEntity;

import java.util.List;

/**
 * <b>菜单信息实体</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class Menu extends BaseEntity {
	private static final long serialVersionUID = 3124685798732030690L;
	private Long id;                         //主键
	private Menu parent;                     //上级菜单
	private String text;                     //菜单文本
	private String url;                      //链接地址
	private String icon;                     //图标
	private List<Menu> childList;            //下级菜单集合
	private List<Role> roleList;             //角色集合

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
