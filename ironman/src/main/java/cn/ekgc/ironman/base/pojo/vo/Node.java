package cn.ekgc.ironman.base.pojo.vo;

import java.io.Serializable;

/**
 * <b>zTree 节点视图信息</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class Node implements Serializable {
	private static final long serialVersionUID = -5256120790857264493L;
	private Long id;                        //主键
	private Long pId;                       //上级主键
	private String name;                    //名称
	private boolean open;                   //是否展示
	private boolean checked;                //是否选择

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
