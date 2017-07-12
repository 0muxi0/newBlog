package com.Lee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.MsgDao;
import com.Lee.domain.Message;

public class MsgDaoImpl extends HibernateDaoSupport implements MsgDao {
	
	//查找留言总条数
	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Message";
		List<Long> list =this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	
	
	//分页查找留言
	@Override
	public List<Message> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Message.class);
		List<Message> list=this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}


	//添加留言
	@Override
	public void add(Message msg) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(msg);
	}


	//通过id查找留言
	@Override
	public Message findById(Integer mid) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Message.class, mid);
	}


	//删除留言
	@Override
	public void delete(Message msg) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(msg);
	}
	

}
