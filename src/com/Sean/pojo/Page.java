package com.Sean.pojo;

import java.io.Serializable;
 
/**
 * 分頁
 */
public class Page implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 4009505922354309291L;

	private int pageNow = 1; // 當前頁數
 
	private int pageSize = 15; // 每頁顯示的數量
 
	private int totalCount; // 總和數量
 
	private int totalPageCount; // 總和頁數
 
	@SuppressWarnings("unused")
	private int startPos; // 開始位置，從0開始
 
	@SuppressWarnings("unused")
	private boolean hasFirst;// 是否有第一頁
 
	@SuppressWarnings("unused")
	private boolean hasPre;// 是否有前一頁
 
	@SuppressWarnings("unused")
	private boolean hasNext;// 是否有下一頁
 
	@SuppressWarnings("unused")
	private boolean hasLast;// 是否有最後一頁
	
	/**
	 * 構造函數 傳入  總和數量  和  當前頁面
	 * @param totalCount
	 * @param pageNow
	 */
	public Page(int totalCount, int pageNow) {
		this.totalCount = totalCount;
		this.pageNow = pageNow;
	}
	
	/**
	 * 取得總頁數，總頁數=總和數量/總頁數
	 * @return
	 */
	public int getTotalPageCount() {
		totalPageCount = getTotalCount() / getPageSize();
		return (totalCount % pageSize == 0) ? totalPageCount
				: totalPageCount + 1;
	}
 
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
 
	public int getPageNow() {
		return pageNow;
	}
 
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
 
	public int getPageSize() {
		return pageSize;
	}
 
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
 
	public int getTotalCount() {
		return totalCount;
	}
 
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * 取得選擇紀錄的初始位置
	 * @return
	 */
	public int getStartPos() {
		return (pageNow - 1) * pageSize;
	}
 
	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}
 
	/**
	 * 是否是第一頁
	 * @return
	 */
	public boolean isHasFirst() {
		return (pageNow == 1) ? false : true;
	}
 
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	/**
	 * 是否有前一頁
	 * @return
	 */
	public boolean isHasPre() {
		// 如果有首頁就有前一頁，因为有首頁就不是第一頁
		return isHasFirst() ? true : false;
	}
 
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	/**
	 * 是否有下一頁
	 * @return
	 */
	public boolean isHasNext() {
		// 如果有尾頁就有下一頁，因为有尾頁表明不是最後一頁
		return isHasLast() ? true : false;
	}
 
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	/**
	 * 是否有尾頁
	 * @return
	 */
	public boolean isHasLast() {
		// 如果不是最後一頁就有尾頁
		return (pageNow == getTotalCount()) ? false : true;
	}
 
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
 
}