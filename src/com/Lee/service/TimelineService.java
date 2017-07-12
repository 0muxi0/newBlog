package com.Lee.service;

import com.Lee.domain.PageBean;
import com.Lee.domain.Timeline;

public interface TimelineService {

	PageBean<Timeline> findByPage(Integer currPage);

	void add(Timeline timeline);

	Timeline findById(Integer tid);

	void delete(Timeline timeline);

	String find(Timeline timeline);

}
