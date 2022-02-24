package com.bhavna.ssw.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bhavna.ssw.users.User;

@Service
public class UserService {
	
	private final Map<Integer, User> map=new HashMap<>();
	
	User user1=new User();
	User user2=new User();

	{
		user1.setUserId(1);
		user1.setUserName("aj");
		user1.setAge(20);
		user1.setLocation("wgl");
		
		user2.setUserId(2);
		user2.setUserName("aee");
		user2.setAge(21);
		user2.setLocation("wgl2");
		
		
		map.put(user1.getUserId(),user1);
		map.put(user2.getUserId(),user2);
	}
	
	public User findById(Integer id) {
		return map.get(id);
	}

}
