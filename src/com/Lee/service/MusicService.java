package com.Lee.service;

import com.Lee.domain.Music;

public interface MusicService {

	String findAll(Music m);

	void add(Music m);

	Music findById(Integer mid);

	void delete(Music m);

	
	
	
	
	
	
}
