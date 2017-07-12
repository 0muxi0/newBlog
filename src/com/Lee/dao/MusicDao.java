package com.Lee.dao;

import java.util.List;

import com.Lee.domain.Music;

public interface MusicDao {

	List<Music> findAll(Music m);

	void add(Music m);

	Music findById(Integer mid);

	void delete(Music m);

	

}
