package com.Lee.service.impl;

import java.util.List;

import com.Lee.dao.MsgDao;
import com.Lee.domain.Message;
import com.Lee.domain.PageBean;
import com.Lee.service.MsgService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MsgServiceImpl implements MsgService {
	
	//注入Dao
	private MsgDao msgDao;
	public void setMsgDao(MsgDao msgDao) {
		this.msgDao = msgDao;
	}


	//分页查找
	@Override
	public PageBean<Message> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Message> pb=new PageBean<Message>();
		pb.setCurrPage(currPage);
		//封装每页显示条数
		int pageSize=20;
		pb.setPageSize(pageSize);
		//封装总条数
		int totalCount=msgDao.findCount();
		pb.setTotalCount(totalCount);
		//总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pb.setTotalPage(num.intValue());
		//每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Message> list =msgDao.findByPage(begin,pageSize);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Message>>() {}.getType());
		List<Message> stringList = gson.fromJson(s, new TypeToken<List<Message>>() {}.getType());
		pb.setList(stringList);
		return pb;
	}

	//添加留言
	@Override
	public void add(Message msg) {
		// TODO Auto-generated method stub
		msgDao.add(msg);
	}

	//通过id查询留言
	@Override
	public Message findById(Integer mid) {
		// TODO Auto-generated method stub
		return msgDao.findById(mid);
	}

	//删除留言
	@Override
	public void delete(Message msg) {
		// TODO Auto-generated method stub
		msgDao.delete(msg);
	}
	
	
	
	

}
