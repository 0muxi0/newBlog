package com.Lee.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.Lee.dao.LoginDao;
import com.Lee.domain.User;

public class LoginDaoImpl extends HibernateDaoSupport implements LoginDao {

	
	
	
	@Override
	public User findByUsernameAndPassword(User user) {
		// TODO Auto-generated method stub
		String hql="from User where username=? and password = ? ";
		List<User> list = this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword());
		if(list.size()>0){
			return list.get(0);
		}
		
		return null;
	}

	
	
}
