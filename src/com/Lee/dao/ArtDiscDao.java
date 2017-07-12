package com.Lee.dao;

import java.util.List;

import com.Lee.domain.ArticleDisc;

public interface ArtDiscDao {

	void add(ArticleDisc artDisc);

	ArticleDisc findById(Integer adid);

	void delete(ArticleDisc artDisc);

	List<ArticleDisc> findByAid(Integer adid);

}
