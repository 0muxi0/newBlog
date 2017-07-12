package com.Lee.service;

import com.Lee.domain.Message;
import com.Lee.domain.PageBean;

public interface MsgService {

	PageBean<Message> findByPage(Integer currPage);

	void add(Message msg);

	Message findById(Integer mid);

	void delete(Message msg);

}
