package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.Message;
import com.Lee.domain.PageBean;
import com.Lee.service.MsgService;
import com.Lee.util.BaseUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 留言板action
 * @author lee
 *
 */
public class MsgAction extends ActionSupport implements ModelDriven<Message> {
	
	//模型驱动
	private Message msg=new Message();
	@Override
	public Message getModel() {
		// TODO Auto-generated method stub
		return msg;
	}

	
	
	//dataMap对象
	private Map<String, Object> dataMap;  
	  
	 public Map<String, Object> getDataMap() {  
	     return dataMap;  
	 }  
	  
	 public void setDataMap(Map<String, Object> dataMap) {  
	     this.dataMap = dataMap;  
	 } 
	 
	 //注入Service
	 private MsgService msgService;
	 public void setMsgService(MsgService msgService) {
		this.msgService = msgService;
	 }
	 
	 
	 
	 
		//当前页
		private Integer currPage=1;
		public void setCurrPage(Integer currPage) {
			this.currPage = currPage;
		}
		
		//分页查留言
		public String findAll() throws IOException{
			
			PageBean<Message> pageBean=msgService.findByPage(currPage);
			//转化为json  字符串
			Gson gson = new Gson(); 
			String s = gson.toJson(pageBean, new TypeToken<PageBean<Message>>() {}.getType());
			JSONObject obj = JSONObject.parseObject(s);
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("list", obj);
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
			return null;
		}
		
		
		
		//添加留言
		public String add() throws IOException{
			try{
				msgService.add(msg);
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
	 
		
		
		//删除留言
		public String delete() throws IOException{
			try{
				msg=msgService.findById(msg.getMid());
				msgService.delete(msg);
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
		
		
		
}


