package com.Lee.service.impl;

import java.util.List;

import com.Lee.dao.ArtDiscDao;
import com.Lee.domain.ArticleDisc;
import com.Lee.service.ArtDiscService;

public class ArtDiscServiceImpl implements ArtDiscService {

	//注入文章评论的Dao
	private ArtDiscDao artDiscDao;
	
	public void setArtDiscDao(ArtDiscDao artDiscDao) {
		this.artDiscDao = artDiscDao;
	}

	
	
	//添加评论
	@Override
	public void add(ArticleDisc artDisc) {
		// TODO Auto-generated method stub
		artDiscDao.add(artDisc);
	}

	//通过id查找评论
	@Override
	public ArticleDisc findById(Integer adid) {
		// TODO Auto-generated method stub
		return artDiscDao.findById( adid);
	}
	
	//删除评论
	@Override
	public void delete(ArticleDisc artDisc) {
		// TODO Auto-generated method stub
		artDiscDao.delete(artDisc);
	}


	//根据文章id查询评论
	@Override
	public List<ArticleDisc> findByAid(Integer adid) {
		// TODO Auto-generated method stub
		List<ArticleDisc> list=  artDiscDao.findByAid(adid);
		return list;
	}
	
}
