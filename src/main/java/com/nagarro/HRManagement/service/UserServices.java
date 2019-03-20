package com.nagarro.HRManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.HRManagement.dlo.UserDetails;
import com.nagarro.HRManagement.repository.UserRepository;

@Service
public class UserServices {
	@Autowired
	UserRepository ur;

	public boolean authenticate(String username, String password) {

		if (ur.findUserDetailsByusername(username).isEmpty()) {
			return false;
		}
		return ur.findUserDetailsByusername(username).get(0).getPassword().equals(password) ? true : false;
	}

	public void addUser(String username, String password) {
		UserDetails ud = new UserDetails();
		ud.setUsername(username);
		ud.setPassword(password);
		ur.save(ud);
	}

}
