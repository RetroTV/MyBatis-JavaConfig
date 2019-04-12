package com.mj.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mj.dao.UserDao;
import com.mj.vo.User;
import com.mj.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public void createDummyUser() {
		userDao.createDummyUser();
	}
	
	@Override
	public User getUserByNoJava(int no) {
		return userDao.getUserByNoJava(no);
	}

	@Override
	public User getUserByNoXml(int no) {
		return userDao.getUserByNoXml(no);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)								// 이렇게 선언하면 Checked Exception이 일어날때도 롤백 처리한다
	public List<User> insertUserList(List<User> users, String example) {
		
		List<User> createdUsers = new ArrayList<>();
		
		if("example3".equals(example)) {
			for(User user : users) {
				if("dummy4".equals(user.getId())) {
					log.error("Dummy4일때 고의로 Exception을 발생시킵니다");
					throw new NullPointerException();							// 트랜잭션은 기본적으로 Unchecked Exception만 롤백 처리한다
				} else {
					log.error(user.getId() + "유저를 추가합니다");
					user.setNo(userDao.createUser(user));
					createdUsers.add(userDao.getUserByNoJava(user.getNo()));
				}
			}
		}
		
		if("example4".equals(example)) {
			for(User user : users) {
				log.info(user.getId() + "유저를 추가합니다");
				user.setNo(userDao.createUser(user));
				createdUsers.add(userDao.getUserByNoJava(user.getNo()));
			}
		}
		
		return createdUsers;
	}
}
