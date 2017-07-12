package com.Lee.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 文章实体
 * @author lee
 *
 */
public class Article {

	private Integer aid;//文章编号
	private String title ;//文章标题
	private String type;//文章类型
	private String author;//作者
	private String address;//地点
	private Date uptime;//时间
	private String remark;//备注
	private String content;//文章文字
	private String imgSrc;//图片地址
	private int numb;//文章浏览次数
	private transient Set<ArticleDisc> articleDiscs=new HashSet<ArticleDisc>();//评论集合（用于外键关联）
	
	
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgSrc() {
		return imgSrc;
	}
	
	public int getNumb() {
		return numb;
	}
	public void setNumb(int numb) {
		this.numb = numb;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	public Set<ArticleDisc> getArticleDiscs() {
		return articleDiscs;
	}
	public void setArticleDiscs(Set<ArticleDisc> articleDiscs) {
		this.articleDiscs = articleDiscs;
	}

	
}
