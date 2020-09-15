package cn.ekgc.ironman.pojo.entity;

import cn.ekgc.ironman.base.pojo.entity.BaseEntity;


/**
 * <b>用户信息实体</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = -6741747561670518043L;
	private Long id;
	private String name;
	private String cellphone;
	private String password;
	private Role role;
	private String idCard;
	private String email;
	private String avatar;

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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cellphone='" + cellphone + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				", idCard='" + idCard + '\'' +
				", email='" + email + '\'' +
				", avatar='" + avatar + '\'' +
				'}';
	}
}
