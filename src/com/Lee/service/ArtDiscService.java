package com.Lee.service;

import java.util.List;

import com.Lee.domain.ArticleDisc;

public interface ArtDiscService {

	void add(ArticleDisc artDisc);
	
/*	PageBean<ArticleDisc> findByPage(Integer currPage);*/

	ArticleDisc findById(Integer adid);

	void delete(ArticleDisc artDisc);

	List<ArticleDisc> findByAid(Integer adid);

	

}
