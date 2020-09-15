package cn.ekgc.ironman.base.pojo.vo;

import cn.ekgc.ironman.util.ConstanUtil;


import java.io.Serializable;
import java.util.List;

/**
 * <b>系统分页信息视图</b>
 * @author Arthur
 * @version 1.0
 * @since 1.0
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = 5761807393519150301L;
	private Integer pageNum;                        // 当前页码
	private Integer pageSize;                       // 每页显示数量
	private Integer draw;                           // dataTables 组件确认信息
	private List<E> list;                           // 分页列表
	private Long totalCount;                        // 总数量
	private Integer totalPage;                      // 总页数

	public Page() {}
	public Page(Integer pageNum, Integer pageSize, Integer draw) {
		if (pageNum != null && pageNum > 0) {
			// 此时所给定的 pageNum 有效
			this.pageNum = pageNum;
		} else {
			this.pageNum = ConstanUtil.PAGE_NUM;
		}

		if (pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		} else {
			this.pageSize = ConstanUtil.PAGE_SIZE;
		}

		this.draw = draw;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
