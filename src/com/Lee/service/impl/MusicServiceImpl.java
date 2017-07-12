package com.Lee.service.impl;

import java.util.List;

import com.Lee.dao.MusicDao;
import com.Lee.domain.Music;
import com.Lee.service.MusicService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MusicServiceImpl implements MusicService {
		
		//注入歌曲管理的Dao
	private MusicDao musicDao;

	public void setMusicDao(MusicDao musicDao) {
		this.musicDao = musicDao;
	}

	//查找歌曲
	@Override
	public String findAll(Music m) {
		// TODO Auto-generated method stub
		List<Music> list = musicDao.findAll(m);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Music>>() {}.getType());
		return s;
	}

	//添加歌曲
	@Override
	public void add(Music m) {
		// TODO Auto-generated method stub
		musicDao.add(m);
	}

	//根据id查找歌曲
	@Override
	public Music findById(Integer mid) {
		// TODO Auto-generated method stub
		return musicDao.findById(mid) ;
	}

	//删除歌曲
	@Override
	public void delete(Music m) {
		// TODO Auto-generated method stub
		musicDao.delete(m);
	}
	
}
