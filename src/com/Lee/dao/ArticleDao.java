package com.Lee.dao;

import java.util.List;

import com.Lee.domain.Article;

/**
 * 文章管理DAO层的接口
 * @author lee
 *
 */
public interface ArticleDao {

	int findCount();

	List<Article> findByPage(int begin, int pageSize);

	void save(Article article);

	Article findById(Integer aid);
	
	void delete(Article article);

	void update(Article article);

	

}
