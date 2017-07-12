package com.Lee.service;

import com.Lee.domain.Article;
import com.Lee.domain.PageBean;

/**
 * 文章管理业务层的接口
 * @author lee
 *
 */
public interface ArticleService {

	PageBean<Article> findByPage(Integer currPage);

	void save(Article article);

	Article findById(Integer aid);
	
	void delete(Article article);

	void update(Article article);

	

}
