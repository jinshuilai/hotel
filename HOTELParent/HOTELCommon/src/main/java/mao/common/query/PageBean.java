package mao.common.query;

import java.util.List;

public class PageBean {

	private List recordList;
	private int currentPage;
	private int pageCount;
	private int pageSize;
	private int recordCount;
	private int beginPageIndex;
	private int endPageIndex;
	
	public PageBean(List recordList, int currentPage, int pageSize, int recordCount) {
		super();
		this.recordList = recordList;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		
		pageCount = (recordCount + pageSize - 1) / pageSize;
		
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}else {
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 9;
			}
		}
	}
	
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}
