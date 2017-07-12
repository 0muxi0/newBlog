package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.PageBean;
import com.Lee.domain.Playlist;
import com.Lee.domain.Timeline;
import com.Lee.service.TimelineService;
import com.Lee.util.BaseUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 时光轴action类
 * @author lee
 *
 */
public class TimelineAction extends ActionSupport implements ModelDriven<Timeline>{
	
	//驱动模型
	private Timeline timeline=new Timeline();
	@Override
	public Timeline getModel() {
		// TODO Auto-generated method stub
		return timeline;
	}

	//dataMap对象
	private Map<String, Object> dataMap;  
		  
	public Map<String, Object> getDataMap() {  
		     return dataMap;  
	 }  
	 public void setDataMap(Map<String, Object> dataMap) {  
		     this.dataMap = dataMap;  
	 } 
	 
	 
	 
	 //注入时光轴的Service
	private TimelineService timelineService;
	public void setTimelineService(TimelineService timelineService) {
		this.timelineService = timelineService;
	}
	 
	 
	
	//当前页
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//分页查时光轴
	public String findAll() throws IOException{
		
		PageBean<Timeline> pageBean=timelineService.findByPage(currPage);
		//转化为json  字符串
		Gson gson = new Gson(); 
		String s = gson.toJson(pageBean, new TypeToken<PageBean<Timeline>>() {}.getType());
		JSONObject obj = JSONObject.parseObject(s);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
		 
	
	
	
	//添加时光轴事件
	public String add() throws IOException{
		try{
			timelineService.add(timeline);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "时光轴发表成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	
	//删除时光轴事件
	public String delete() throws IOException{
		try{
			timeline=timelineService.findById(timeline.getTid());
			timelineService.delete(timeline);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "时光轴删除成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
			
		}
		return null;
	}
	
	//查看所有时光轴事件
	public String find() throws IOException{
		
		
			String list=timelineService.find(timeline);
			Gson gson = new Gson();
			List<Timeline> stringList = gson.fromJson(list, new TypeToken<List<Timeline>>() {}.getType());
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("list", stringList);
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
			return null;
	}
	
	
}
