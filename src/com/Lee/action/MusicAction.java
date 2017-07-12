package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.Music;
import com.Lee.service.MusicService;
import com.Lee.service.PlaylistService;
import com.Lee.util.BaseUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MusicAction {

	
	private Music m=new Music();

	public Music getM() {
		return m;
	}
	
	//注入service
	private MusicService musicService;

	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}
	private PlaylistService playlistService;

	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	
	
	
	//查找所有歌曲
	private String findAll() throws IOException{
		String list = musicService.findAll(m);
		Gson gson = new Gson(); 
		List<Music> stringList = gson.fromJson(list, new TypeToken<List<Music>>() {}.getType());
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", stringList);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
	//添加歌曲
	private String add() throws IOException{
		
		try{
			musicService.add(m);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "歌曲添加成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	//删除歌曲
	private String delete() throws IOException{
		try{
			m=musicService.findById(m.getMid());
			musicService.delete(m);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "歌曲删除成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
		
	}
	
	
	
	//根据歌单id查询歌曲
	public String findMusByPid(){
	
		
		return null;
	}
	
	
}
