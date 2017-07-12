package com.Lee.dao;

import com.Lee.domain.User;

public interface LoginDao {

	User findByUsernameAndPassword(User user);
}
