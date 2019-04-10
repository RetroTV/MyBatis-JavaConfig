package com.mj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mj.vo.User;

@Mapper
public interface UserMapper {
	
	/*	
	 * 	유의사항!
	 *
	 *	SQL을 String + String 형태로 작성할 때는 항상 마지막에 띄어쓰기를 할 것
	 *	마지막 줄에는 안해도 됨
	 */
	
	//Java 어노테이션을 이용하는 매퍼
	@Insert("INSERT INTO users ( " 	+		//	INSERT INTO users (
				"user_id, " 		+ 		//		user_id,
				"user_password, " 	+ 		//		user_password,
				"user_name, " 		+ 		//		user_name,
				"user_email) " 		+ 		//		user_emial)
			"VALUES ( " 			+		//	VALUES (
				"\"dummy\", " 		+ 		//		"dummy",
				"\"password\", " 	+		//		"password",
				"\"Dummy\", " 		+		//		"Dummy",
				"\"dummy@gamil.com\")")		//		"dummy@gamail.com")
	public void createDummyUser();
	
	@Select("SELECT "							+
				"user_id 	   AS id, "			+
				"user_password AS password, "	+
				"user_name 	   AS name, "		+
				"user_email    AS email "		+
			"FROM "								+
				"users "						+
			"WHERE "							+
				"user_no = #{value}")
	public User getUserByNoJava(int no);
	
	//Xml 매핑을 이용하는 매퍼
	public User getUserByNoXml(int no);
	
	public void createUser(User user);	
}
