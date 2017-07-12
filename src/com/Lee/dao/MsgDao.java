package com.Lee.dao;

import java.util.List;

import com.Lee.domain.Message;

public interface MsgDao {

	int findCount();

	List<Message> findByPage(int begin, int pageSize);

	void add(Message msg);

	Message findById(Integer mid);

	void delete(Message msg);

}
