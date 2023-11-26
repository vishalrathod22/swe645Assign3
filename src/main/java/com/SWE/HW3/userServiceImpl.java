package com.SWE.HW3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SWE.HW3.exception.ResourceNotFoundException;
import com.SWE.HW3.model.user;
import com.SWE.HW3.repository.UserRepository;
import com.SWE.HW3.service.userService;

@Service
public class userServiceImpl implements userService{

	private UserRepository userRepository;
	
	
	public userServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public user saveUser(user User) {
		// TODO Auto-generated method stub
		return userRepository.save(User);
	}


	@Override
	public List<user> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}


	@Override
	public user getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<user> users = userRepository.findById(id);
		
		if(users.isPresent()) {
			return users.get();
		}
		else {
			throw new ResourceNotFoundException("user", "Id", id);
		}
		
//		return userRepository.findById(id).orElseThrow(() -> ResourceNotFoundException("user", "Id", id));
	}


	@Override
	public user updateUser(user User, long id) {
		
		//checking the id is present in the database or not
		user existUser = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("user", "Id", id));
		
		existUser.setFirstName(User.getFirstName());
		existUser.setLastName(User.getLastName());
		existUser.setCity(User.getCity());
		existUser.setDos(User.getDos());
		existUser.setEmail(User.getEmail());
		existUser.setLikedMost(User.getLikedMost());
		existUser.setRecommendation(User.getRecommendation());
		existUser.setState(User.getState());
		existUser.setUrl(User.getUrl());
		existUser.setZip(User.getZip());
		existUser.setTelphone(User.getTelphone());
		existUser.setInterested(User.getInterested());
		existUser.setStreetAddress(User.getStreetAddress());
		
		//saving the updated information
		userRepository.save(existUser);
		
		
		return existUser;
	}


//	@Override
//	public void deleteUser(long id) {
//		
//		//check if the user data is there in database or not
//		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "Id", id));
//		userRepository.deleteAll();
//		
//	}


	@Override
	public
	void deleteAllUser() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
//		return "Deleted Successfully";
		
	}


	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}


//@Override
//public void deleteUser(long id) {
//	// TODO Auto-generated method stub
//	
//}

}
