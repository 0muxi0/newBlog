package com.Lee.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.Lee.domain.Article;
import com.Lee.domain.ArticleDisc;
//import com.Lee.domain.UtilE;
import com.Lee.service.ArtDiscService;
import com.Lee.service.ArticleService;
import com.Lee.util.BaseUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ArtDiscAction extends ActionSupport implements ModelDriven<ArticleDisc> {

	//驱动模型
	private ArticleDisc artDisc=new ArticleDisc();
	private Article article = new Article();
	public Article getArticle() {
		return article;
	}
	@Override
	public ArticleDisc getModel() {
		// TODO Auto-generated method stub
		return artDisc;
	}

	//dataMap对象
	private Map<String, Object> dataMap;  
		  
	public Map<String, Object> getDataMap() {  
		     return dataMap;  
	 }  
	 public void setDataMap(Map<String, Object> dataMap) {  
		     this.dataMap = dataMap;  
	 } 
	 
	 
	 
	 //注入文章评论的Service
	private ArtDiscService artDiscService;
	
	
	private ArticleService articleService;
 	public void setArtDiscService(ArtDiscService artDiscService) {
		this.artDiscService = artDiscService;
	}
 	

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	
	
	
/*	//当前页
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//分页查评论
	public String findAll() throws IOException{
		
		PageBean<ArticleDisc> pageBean=artDiscService.findByPage(currPage);
		//转化为json  字符串
		Gson gson = new Gson(); 
		String s = gson.toJson(pageBean, new TypeToken<PageBean<ArticleDisc>>() {}.getType());
		JSONObject obj = JSONObject.parseObject(s);
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("returnCode", 0);
		dataMap.put("list", obj);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	*/
	
	


	//添加评论
	public String add() throws IOException{
		
		ArticleDisc artD = new ArticleDisc();
		Integer xid = artDisc.getToId();
		article = articleService.findById(xid);
		artD.setArticle(article);
		artD.setToId(artDisc.getToId());
		artD.setContent(artDisc.getContent());
		artD.setUptime(artDisc.getUptime());
		artD.setOname(artDisc.getOname());
		artD.setSid(artDisc.getSid());
		artD.setToname(artDisc.getToname());
		try{
			artDiscService.add(artD);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "评论发表成功！");
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}catch(Exception e){
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 1);
			dataMap.put("des", BaseUtil.getExceptionDetail(e));
			BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		}
		return null;
	}
	
	
	
	
	//根据文章id查询文章评论
	public String findArtDisc() throws IOException{
		Integer adid = artDisc.getToId();
		List<ArticleDisc> a= artDiscService.findByAid(adid);
		Gson gson = new Gson();
		String s = gson.toJson(a, new TypeToken<List<ArticleDisc>>() {}.getType());
		List<ArticleDisc> stringList = gson.fromJson(s, new TypeToken<List<ArticleDisc>>() {}.getType());
		Map<String, Object>	dataMap = new HashMap<String,Object>();
		dataMap.put("ret", 0);
		dataMap.put("list", stringList);
		BaseUtil.toJson(ServletActionContext.getResponse(), dataMap);
		return null;
	}
	
	
	
	
	//删除评论
	public String delete() throws IOException{
		try{
			artDisc=artDiscService.findById(artDisc.getAdid());
			artDiscService.delete(artDisc);
			Map<String,Object> dataMap=new HashMap<String,Object>();
			dataMap.put("ret", 0);
			dataMap.put("des", "评论删除成功！");
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
