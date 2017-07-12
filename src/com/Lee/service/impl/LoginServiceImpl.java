package com.Lee.service.impl;

import com.Lee.dao.LoginDao;
import com.Lee.domain.User;
import com.Lee.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;
	
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		User existUser = loginDao.findByUsernameAndPassword(user);
		
		return existUser;
	}

}
