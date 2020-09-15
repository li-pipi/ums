package cn.ekgc.ironman.base.pojo.enums;


/**
 * <b>HTTP响应码枚举类型</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public enum ResponseCode {
	RESPONSE_CODE_200(200, "系统响应成功"),
	RESPONSE_CODE_500(500, "系统响应失败");

	private Integer code;
	private String remark;
	private ResponseCode(Integer code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
