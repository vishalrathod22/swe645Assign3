package com.SWE.HW3.service;

import java.util.List;

//import com.SWE.HW3.controller.UserService;
import com.SWE.HW3.model.user;

public interface userService {
	user saveUser(user User);
	List<user> getAllUsers();
	user getUserById(long id);
	user updateUser(user User, long id);
	void deleteUser(long id);
	void deleteAllUser();
}


