package com.Lee.service.impl;

import java.util.List;

import com.Lee.dao.PlaylistDao;
import com.Lee.domain.Playlist;
import com.Lee.service.PlaylistService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PlaylistServiceImpl implements PlaylistService {

	
	//注入歌单的Dao
	private PlaylistDao playlistDao;
	
	public void setPlaylistDao(PlaylistDao playlistDao) {
		this.playlistDao = playlistDao;
	}
	
	
//添加歌单
	@Override
	public void add(Playlist plist) {
		// TODO Auto-generated method stub
		playlistDao.add(plist);
	}
	
	
	
//通过id查找歌单
	@Override
	public Playlist findById(Integer pid) {
		// TODO Auto-generated method stub
		return playlistDao.findById(pid);
	}
	
	
	
//删除歌单
	@Override
	public void delete(Playlist plist) {
		// TODO Auto-generated method stub
		playlistDao.delete(plist);
	}

	//查看所有歌单
	@Override
	public String findAll(Playlist plist) {
		// TODO Auto-generated method stub
		List<Playlist> list =playlistDao.findAll(plist);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Playlist>>() {}.getType());
//		List<Playlist> stringList = gson.fromJson(s, new TypeToken<List<Playlist>>() {}.getType());
		return s;
	}


	@Override
	public void update(Playlist plist) {
		// TODO Auto-generated method stub
		playlistDao.update(plist);
	}
	
	
	
	
	
	
/*//分页查看歌单
	@Override
	public PageBean<Playlist> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		//获取对象
		PageBean<Playlist> pb=new PageBean<Playlist>();
		//当前页
		pb.setCurrPage(currPage);
		//封装每页显示条数
		int pageSize=20;
		pb.setPageSize(pageSize);
		//封装总条数
		int totalCount=playlistDao.findCount();
		pb.setTotalCount(totalCount);
		//总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pb.setTotalPage(num.intValue());
		//每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Playlist> list =playlistDao.findByPage(begin,pageSize);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Playlist>>() {}.getType());
		List<Playlist> stringList = gson.fromJson(s, new TypeToken<List<Playlist>>() {}.getType());
		pb.setList(stringList);
		return pb;
		
	}*/
	
}
