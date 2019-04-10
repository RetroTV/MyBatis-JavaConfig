package com.mj.service;

import java.util.List;

import com.mj.vo.User;

public interface UserService {

	public void createDummyUser();
	public User getUserByNoJava(int no);
	public User getUserByNoXml(int no);
	public void createUser(User user);
	public List<User> insertUserList(List<User> users, String example);
}
