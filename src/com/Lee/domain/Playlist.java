package com.Lee.domain;

import java.util.HashSet;
import java.util.Set;
/**
 * 歌单实体
 * @author lee
 *
 */
public class Playlist {
	private Integer pid;//歌单id
	private String pname;//歌单名字
	private String pdesc;//歌单描述
	private String plable;//歌单标签
	private String createtime;//创建时间
	private String pImg;//歌单封面地址
	
	//外键关联
	private Set<Music> musics=new HashSet<Music>();//歌曲集合

	
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPlable() {
		return plable;
	}

	public void setPlable(String plable) {
		this.plable = plable;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getpImg() {
		return pImg;
	}

	public void setpImg(String pImg) {
		this.pImg = pImg;
	}

	public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
	
	
}
