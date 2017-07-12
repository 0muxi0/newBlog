package com.Lee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.MusicDao;
import com.Lee.domain.Music;

public class MusicDaoImpl  extends  HibernateDaoSupport implements MusicDao {

	
	//查找所有歌曲
	@Override
	public List<Music> findAll(Music m) {
		// TODO Auto-generated method stub
		List<Music> list = this.getHibernateTemplate().loadAll(Music.class);
		return list;
	}

	//添加歌曲
	@Override
	public void add(Music m) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(m);
	}
	
	//根据id查找歌曲
	@Override
	public Music findById(Integer mid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Music.class,mid);
	}

//	删除歌曲
	@Override
	public void delete(Music m) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(m);
	}

	//编辑歌曲
	
	
}
