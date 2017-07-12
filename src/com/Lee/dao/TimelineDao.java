package com.Lee.dao;

import java.util.List;

import com.Lee.domain.Timeline;

public interface TimelineDao {

	int findCount();

	List<Timeline> findByPage(int begin, int pageSize);

	void add(Timeline timeline);

	Timeline findById(Integer tid);

	void delete(Timeline timeline);

	List<Timeline> find(Timeline timeline);

}
