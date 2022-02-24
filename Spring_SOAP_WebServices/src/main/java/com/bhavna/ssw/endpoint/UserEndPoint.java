package com.bhavna.ssw.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.bhavna.ssw.service.UserService;
import com.bhavna.ssw.users.User;
import com.bhavna.ssw.users.UserRequest;
import com.bhavna.ssw.users.UserResponse;

@Endpoint
public class UserEndPoint {
	
	 private static final String NAMESPACE_URI = "http://www.bhavna.com/ssw/users";
	 
	 @Autowired
	 UserService userService;
	 
	 @PayloadRoot(namespace = NAMESPACE_URI, localPart = "userRequest")
	 @ResponsePayload
	 public UserResponse getById(@RequestPayload UserRequest request) {
		 UserResponse resp=new UserResponse();
		 resp.setUser(userService.findById(request.getUserId()));
		 return resp;
	 }

}
