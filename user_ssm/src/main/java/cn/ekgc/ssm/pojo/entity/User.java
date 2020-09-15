package cn.ekgc.ssm.pojo.entity;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -253731446334229807L;
	private Long id;
	private String name;
	private String cellphone;

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
}
