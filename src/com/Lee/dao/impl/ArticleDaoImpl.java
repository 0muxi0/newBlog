package com.Lee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.ArticleDao;
import com.Lee.domain.Article;

/**
 * 文章管理DAO层的实现类
 * @author lee
 *
 */
public class ArticleDaoImpl  extends HibernateDaoSupport implements ArticleDao {
	//查找文章总条数
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Article";
		List<Long> list= this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//分页查找文章
	@Override
	public List<Article> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
		List<Article> list= this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	
	//添加文章
	@Override
	public void save(Article article) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(article);
	}
	
	//通过id查询文章
	@Override
	public Article findById(Integer aid) {
		// TODO Auto-generated method stub
//		List<Article> list = (List<Article>) this.getHibernateTemplate().get(Article.class,aid);
		return this.getHibernateTemplate().get(Article.class,aid);
		
	}
	
	//删除文章
	@Override
	public void delete(Article article) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(article);
	}
	
	//更新文章
	@Override
	public void update(Article article) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(article);
	}
	

	
}
