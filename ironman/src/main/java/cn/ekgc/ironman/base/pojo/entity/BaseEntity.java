package cn.ekgc.ironman.base.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础信息实体</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -3360955498842622807L;
	private Integer status;                     //系统状态：0-禁用，1-启用
	private Date createTime;                    //创建时间

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	private Date updateTime;                    //修改时间
}
