package com.Lee.service;


import com.Lee.domain.Playlist;

public interface PlaylistService {

	void add(Playlist plist);

	Playlist findById(Integer pid);

	void delete(Playlist plist);

//	PageBean<Playlist> findByPage(Integer currPage);

	String findAll(Playlist plist);

	void update(Playlist plist);


}
