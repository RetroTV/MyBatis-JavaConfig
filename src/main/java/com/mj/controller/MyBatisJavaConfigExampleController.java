package com.mj.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mj.service.UserService;
import com.mj.vo.User;

@Controller
public class MyBatisJavaConfigExampleController {
	
	@Autowired
	private UserService userService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/example1", method = RequestMethod.GET)
	public String example1(Model model) {
		
		User userJava = userService.getUserByNoJava(1);
		
		if(userJava == null) {
			log.info("해당 데이터베이스에 데이터가 없습니다.");
			log.info("더미 데이터를 추가합니다");
			
			userService.createDummyUser();
			log.info("더미 데이터 추가가 완료되었습니다");
			
			userJava = userService.getUserByNoJava(1);
		}
		
		model.addAttribute("userJava", userJava);
		
		return "example1";
	}
	
	@RequestMapping(value = "/example2", method = RequestMethod.GET)
	public String example2(Model model) {
		
		User userXml = userService.getUserByNoXml(1);
		
		if(userXml == null) {
			log.info("해당 데이터베이스에 데이터가 없습니다.");
			log.info("더미 데이터를 추가합니다");
			
			userService.createDummyUser();
			log.info("더미 데이터 추가가 완료되었습니다");
			
			userXml = userService.getUserByNoXml(1);
		}
		
		model.addAttribute("userXml", userXml);
		
		return "example2";
	}
	
	@RequestMapping(value = "/example3", method = RequestMethod.GET)
	public String example3(Model model) {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("dummy1", "password", "dummy1@gmail.com", "Dummy1"));
		users.add(new User("dummy2", "password", "dummy2@gmail.com", "Dummy2"));
		users.add(new User("dummy3", "password", "dummy3@gmail.com", "Dummy3"));
		users.add(new User("dummy4", "password", "dummy4@gmail.com", "Dummy4"));
		users.add(new User("dummy5", "password", "dummy5@gmail.com", "Dummy5"));
		
		users = userService.insertUserList(users, "example3");
		model.addAttribute("users", users);
		
		return "example3";
	}
	
	@RequestMapping(value = "/example4", method = RequestMethod.GET)
	public String example4(Model model) {
		
		List<User> users = new ArrayList<>();
		
		users.add(new User("dummy1", "password", "dummy1@gmail.com", "Dummy1"));
		users.add(new User("dummy2", "password", "dummy2@gmail.com", "Dummy2"));
		users.add(new User("dummy3", "password", "dummy3@gmail.com", "Dummy3"));
		users.add(new User("dummy4", "password", "dummy4@gmail.com", "Dummy4"));
		users.add(new User("dummy5", "password", "dummy5@gmail.com", "Dummy5"));
		
		users = userService.insertUserList(users, "example4");
		model.addAttribute("users", users);
		
		return "example4";
	}
}

