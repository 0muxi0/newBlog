package com.Lee.service.impl;

import java.util.List;

import com.Lee.dao.TimelineDao;
import com.Lee.domain.PageBean;
import com.Lee.domain.Playlist;
import com.Lee.domain.Timeline;
import com.Lee.service.TimelineService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TimelineServiceImpl implements TimelineService {
	
	//注入时光轴管理的Dao
	private TimelineDao timelineDao;
	
	public void setTimelineDao(TimelineDao timelineDao) {
		this.timelineDao = timelineDao;
	}


	
	//分页查找时光轴
	@Override
	public PageBean<Timeline> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		//获取对象
		PageBean<Timeline> pb=new PageBean<Timeline>();
		//当前页
		pb.setCurrPage(currPage);
		//封装每页显示条数
		int pageSize=20;
		pb.setPageSize(pageSize);
		//封装总条数
		int totalCount=timelineDao.findCount();
		pb.setTotalCount(totalCount);
		//总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pb.setTotalPage(num.intValue());
		//每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Timeline> list =timelineDao.findByPage(begin,pageSize);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Timeline>>() {}.getType());
		List<Timeline> stringList = gson.fromJson(s, new TypeToken<List<Timeline>>() {}.getType());
		pb.setList(stringList);
		return pb;
	}


	//添加时光轴
	@Override
	public void add(Timeline timeline) {
		// TODO Auto-generated method stub
		timelineDao.add(timeline);
	}


	//通过id查询时光轴数据
	@Override
	public Timeline findById(Integer tid) {
		// TODO Auto-generated method stub
		return timelineDao.findById(tid);
	}


	//删除时光轴
	@Override
	public void delete(Timeline timeline) {
		// TODO Auto-generated method stub
		timelineDao.delete(timeline);
	}


//查看所有时光轴事件
	@Override
	public String find(Timeline timeline) {
		// TODO Auto-generated method stub
		List<Timeline> list = timelineDao.find(timeline);
		Gson gson = new Gson();
		String s = gson.toJson(list, new TypeToken<List<Timeline>>() {}.getType());
		return s;
	}

	
	
	
	
	
}
