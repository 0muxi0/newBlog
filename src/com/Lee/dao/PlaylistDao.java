package com.Lee.dao;


import java.util.List;

import com.Lee.domain.Playlist;

public interface  PlaylistDao {

	void add(Playlist plist);

	Playlist findById(Integer pid);

	void delete(Playlist plist);

	int findCount();

//	List<Playlist> findByPage(int begin, int pageSize);

	List<Playlist> findAll(Playlist plist);

	void update(Playlist plist);

}
