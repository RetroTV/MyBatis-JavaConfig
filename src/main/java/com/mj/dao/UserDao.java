package com.mj.dao;

import com.mj.vo.User;

public interface UserDao {

	public void createDummyUser();
	public User getUserByNoJava(int no);
	public User getUserByNoXml(int no);
	public int createUser(User user);
}
