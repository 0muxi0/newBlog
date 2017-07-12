package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.Playlist;
import com.Lee.service.PlaylistService;
import com.Lee.util.BaseUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlaylistAction extends ActionSupport implements ModelDriven<Playlist> {
	//驱动模型
	private Playlist plist=new Playlist();
	@Override
	public Playlist getModel() {
		// TODO Auto-generated method stub
		return plist;
	}

	//dataMap对象
	private Map<String, Object> dataMap;  
		  
	public Map<String, Object> getDataMap() {  
		     return dataMap;  
	 }  
	 public void setDataMap(Map<String, Object> dataMap) {  
		     this.dataMap = dataMap;  
	 } 
	 
	 
	 
	 //注入歌单的Service
	private PlaylistService playlistService;
	public void setPlaylistService(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	
	
/*	//当前页
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	*/
	//查询歌单
	public String findAll() throws IOException{
		
/*		PageBean<Playlist> pageBean=playlistService.findByPage(currPage);
		//转化为json  字符串
		Gson gson = new Gson(); 
		String s = gson.toJson(pageBean, new TypeToken<PageBean<Playlist>>() {}.getType());
		JSONObject obj = JSONObject.parseObject(s);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;*/
		String list = playlistService.findAll(plist);
		Gson gson = new Gson(); 
//		String s = gson.toJson(list, new TypeToken<List<Playlist>>() {}.getType());
//		JSONObject obj= JSONObject.parseObject(list);
		List<Playlist> stringList = gson.fromJson(list, new TypeToken<List<Playlist>>() {}.getType());
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", stringList);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
	
	//新建歌单
	public String add() throws IOException{
		try{
			playlistService.add(plist);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "歌单添加成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	
	//删除歌单
	public String delete() throws IOException{
		try{
			plist=playlistService.findById(plist.getPid());
			playlistService.delete(plist);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "歌单删除成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
		
	}
	
	
	
	//编辑歌单
	public String edit() throws IOException{
		plist = playlistService.findById(plist.getPid());
		Gson gson = new Gson(); 
		String s=gson.toJson(plist);
		JSONObject obj = JSONObject.parseObject(s);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("data", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
	
	//修改歌单
	public String update() throws IOException{
		try{
			playlistService.update(plist);
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("description", "歌单更新成功");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("returnCode", 1);
			dataMap.put("description", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
}
