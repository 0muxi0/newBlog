package com.Lee.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.Lee.dao.ArticleDao;
import com.Lee.domain.Article;
import com.Lee.domain.PageBean;
import com.Lee.service.ArticleService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * 文章管理业务层的实现类
 * @author lee
 *
 */
@Transactional  //事务管理
public class ArticleServiceImpl implements ArticleService {

	//注入文章管理的DAO
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	
	//分页查找文章
	@Override
	public PageBean<Article> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		//获取对象
		PageBean<Article> pageBean=new PageBean<Article>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的条数
		int pageSize=8;
		pageBean.setPageSize(pageSize);
		//封装总条数
		int totalCount=articleDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Article> list=articleDao.findByPage(begin,pageSize);
		
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Article>>() {}.getType());
//		System.out.println(s);
		List<Article> stringList = gson.fromJson(s, new TypeToken<List<Article>>() {}.getType());
//		System.out.println(stringList);
		pageBean.setList(stringList);
		return pageBean;
	}
	
	//添加文章
	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		articleDao.save(article);
	}

	//通过文章ID查询文章
	@Override
	public Article findById(Integer aid) {
		// TODO Auto-generated method stub
		return articleDao.findById(aid);
	}
	
	//删除文章
	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		articleDao.delete(article);
	}


	//更新文章
	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		articleDao.update(article);
	}






}
