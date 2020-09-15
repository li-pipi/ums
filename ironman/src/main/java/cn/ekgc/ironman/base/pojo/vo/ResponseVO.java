package cn.ekgc.ironman.base.pojo.vo;

import cn.ekgc.ironman.base.pojo.enums.ResponseCode;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.font.TrueTypeFont;

import javax.xml.transform.Result;
import java.io.Serializable;

/**
 * <b>响应视图信息</b>
 * @author Admin
 * @version 1.0
 * @since 1.0
 */
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -450631076428844916L;
	private Integer code;                        //HTTP响应码
	private boolean result;                      //系统处理结果
	private E data;                              //响应结果数据
	public ResponseVO(ResponseCode responseCode, boolean result) {
		this.code = responseCode.getCode();
		this.result = result;
	}
	public ResponseVO(ResponseCode responseCode, boolean result, E data) {
		this.code = responseCode.getCode();
		this.result = result;
		this.data = data;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统响应处理成功视图对象</b>
	 * @return
	 */
	public static ResponseVO success() {
		return new ResponseVO(ResponseCode.RESPONSE_CODE_200, true);
	}


	/**
	 * <b>获得系统响应处理成功视图对象</b>
	 * @return
	 */
	public static ResponseVO success(Object data) {
		return new ResponseVO(ResponseCode.RESPONSE_CODE_200, true, data);
	}

	/**
	 * <b>获得系统响应处理失败视图对象</b>
	 * @return
	 */
	public static ResponseVO error(Object data) {
		return new ResponseVO(ResponseCode.RESPONSE_CODE_200,false, data);
	}

	public static ResponseVO failure(Object data) {
		return new ResponseVO(ResponseCode.RESPONSE_CODE_500, false, data);
	}
}


