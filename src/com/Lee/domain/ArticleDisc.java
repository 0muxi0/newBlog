package com.Lee.domain;
/*
 * 文章评论实体
 */
public class ArticleDisc {

	private Integer adid;//文章评论id
	private String content;//评论内容
	private String oname;//评论发出者的名字
	private Integer toId;//此评论对应那篇文章的ID
	private String toname;//评论哪个人的名字
	private String uptime;//评论时间
	private Integer sid;//回复至adid（null表示一级评论,!null表示二级）
	
	

	private Article article;//所属文章
	
	
	
	public Integer getAdid() {
		return adid;
	}
	public void setAdid(Integer adid) {
		this.adid = adid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public Integer getToId() {
		return toId;
	}
	public void setToId(Integer toId) {
		this.toId = toId;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	

	

	
	
	
	
	
}
