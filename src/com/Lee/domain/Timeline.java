package com.Lee.domain;
/**
 * 时光轴记录
 * @author lee
 *
 */

public class Timeline {

	private Integer tid;//说说id
	private String uptime;//更新时间
	private String content;//内容
	private String year;//年份
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
