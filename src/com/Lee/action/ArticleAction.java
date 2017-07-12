package com.Lee.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;



import com.Lee.domain.Article;
import com.Lee.domain.PageBean;
import com.Lee.service.ArticleService;
import com.Lee.util.BaseUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

/**
 * 文章管理的action类
 * @author lee
 *
 */
/*@ParentPackage(value = "json-default")  
@Results( { @Result(name = ActionSupport.SUCCESS, type = "json"),@Result(name = ActionSupport.ERROR, type = "json") })*/
public class ArticleAction extends ActionSupport implements ModelDriven<Article>{
	//模型驱动使用的对象
	private Article article=new Article();
	@Override
	public Article getModel() {
		// TODO Auto-generated method stub
		return article;
	}
	
	//dataMap对象
	private Map<String, Object> dataMap;  
	  
	 public Map<String, Object> getDataMap() {  
	     return dataMap;  
	 }  
	  
	 public void setDataMap(Map<String, Object> dataMap) {  
	     this.dataMap = dataMap;  
	 } 


	//注入文章管理的Service
	private ArticleService articleService;
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	
	
	
	//当前页
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//分页查找文章
	public String findAll() throws IOException{
		
		PageBean<Article> pageBean=articleService.findByPage(currPage);
		//转化为json  字符串
		Gson gson = new Gson(); 
		String s = gson.toJson(pageBean, new TypeToken<PageBean<Article>>() {}.getType());
//		String s=gson.toJson(pageBean);
//		System.out.println(s);
		JSONObject obj = JSONObject.parseObject(s);
//		System.out.println(obj);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
/*	@Action(className = "ArticleAction", value = "/save",  
	         results = @Result(type = "json", params = {  
	                 "noCache", "true",         // 是否启用缓存  
	                 "enableGZIP", "true",      // 是否对响应JSON启用GZIP  
	                 "contentType", "text/html",// 设置响应的内容类型  
	                 "root", "dataMap",         // 设置根对象  
	                 "ignoreHierarchy", "true"  // 忽略基类  
	         }))  */

//	@Action(value="save", results={@Result(type="json", params={"root","dataMap"})})
	//添加文章
	public String save() throws IOException{
		try{
			articleService.save(article);
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("description", "文章添加成功");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch (Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("returnCode", 1);
			dataMap.put("description", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	
	//删除文章
	public String delete() throws IOException{
		try{
			article=articleService.findById(article.getAid());
			
			articleService.delete(article);
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("description", "文章删除成功");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("returnCode", 1);
			dataMap.put("description", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	//编辑文章
	public String edit() throws IOException{
		article = articleService.findById(article.getAid());
		Gson gson = new Gson(); 
		String s=gson.toJson(article);
		JSONObject obj = JSONObject.parseObject(s);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("data", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
	//更新文章
	public String update() throws IOException{
		try{
			articleService.update(article);
			Map<String, Object>	dataMap = new HashMap<String,Object>();
			dataMap.put("returnCode", 0);
			dataMap.put("description", "文章更新成功");
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
