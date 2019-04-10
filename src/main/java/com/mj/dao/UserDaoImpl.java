package com.mj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mj.mapper.UserMapper;
import com.mj.vo.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void createDummyUser() {			
		userMapper.createDummyUser();
	}	
	
	@Override
	public User getUserByNoJava(int no) {
		return userMapper.getUserByNoJava(no);
	}

	@Override
	public User getUserByNoXml(int no) {
		return userMapper.getUserByNoXml(no);
	}

	@Override
	public int createUser(User user) {
		userMapper.createUser(user);
		int createdUserNo = user.getNo();
		
		return createdUserNo;
	}
}
