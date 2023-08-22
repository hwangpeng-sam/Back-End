package com.example.plugissue;


import com.example.plugissue.user.UserDao;
import com.example.plugissue.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import  java.util.List;

@SpringBootTest
class PlugissueApplicationTests { // data 잘 들어가나 test 할 수 있음.

	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
	}

	@Test
	void addUserRTest() {
		User user= new User();
		user.setId("cdh5306");
		user.setPassword("1234");
		user.setName("장찬희");
		user.setAge(1);

		userDao.save(user);
	}
	//@Test
	void grtAllUsersAndDeleteThem(){
		List<User> users = userDao.getAllUsers(); //받아온 걸 user에 저장해서
		for (User user: users){
			userDao.delete(user);
		}
	}


}
