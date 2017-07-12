package com.Lee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.ArtDiscDao;
import com.Lee.domain.ArticleDisc;

public class ArtDiscDaoImpl extends HibernateDaoSupport  implements ArtDiscDao {
	//添加评论
	@Override
	public void add(ArticleDisc artDisc) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(artDisc);
	}

	//通过id查看评论
	@Override
	public ArticleDisc findById(Integer adid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(ArticleDisc.class, adid);
	}
	
	
	//删除评论
	@Override
	public void delete(ArticleDisc artDisc) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(artDisc);
	}

	//根据文章id查询评论
	@Override
	public List<ArticleDisc> findByAid(Integer adid) {
		// TODO Auto-generated method stub
		String hql="from ArticleDisc a where a.article.aid=? ";
		List<ArticleDisc> list=getHibernateTemplate().find(hql,adid);
		return list;
	}

}
