package com.Lee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.TimelineDao;
import com.Lee.domain.Playlist;
import com.Lee.domain.Timeline;

public class TimelineDaoImpl extends HibernateDaoSupport implements TimelineDao {
	
	//查找总条数
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Timeline";
		List<Long> list =this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//分页查询数据
	@Override
	public List<Timeline> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Timeline.class);
		List<Timeline> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}
	
	//添加时光轴
	@Override
	public void add(Timeline timeline) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(timeline);
	}

	
	//通过tid查询时光轴
	@Override
	public Timeline findById(Integer tid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Timeline.class,tid);
	}
	
	
	//删除时光轴
	@Override
	public void delete(Timeline timeline) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(timeline);
	}

	//查找所有时光轴事件
	@Override
	public List<Timeline> find(Timeline timeline) {
		// TODO Auto-generated method stub
		List<Timeline> list = this.getHibernateTemplate().loadAll(Timeline.class);
		return list;
	}

}
