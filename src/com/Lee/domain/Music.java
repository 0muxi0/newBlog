package com.Lee.domain;

/**
 * 歌曲实体
 * @author lee
 *
 */
public class Music {
	private Integer mid;//歌曲id
	private String mname;//歌名
	private String singer;//原唱
	private String singerImg;//原唱头像
	private String lyric;//歌词
	private String collection;//歌曲所属专辑
	private String url;//歌曲地址
	private  Playlist  playlist;//所属歌单

	
	
	
	
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSingerImg() {
		return singerImg;
	}

	public void setSingerImg(String singerImg) {
		this.singerImg = singerImg;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
	
	
	
}
