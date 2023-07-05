package com.ptpl.veternary_website.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptpl.veternary_website.entities.User;
import com.ptpl.veternary_website.payloads.UserDto;
import com.ptpl.veternary_website.repositories.UserRepo;
import com.ptpl.veternary_website.services.UserService;
import com.ptpl.veternary_website.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		return this.userToDto(this.userRepo.save(this.dtoToUser(userDto)));
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMblNo(userDto.getMblNo());
		user.setEmailId(userDto.getEmailId());
		user.setCityNation(userDto.getCityNation());
		user.setPassword(userDto.getPassword());
		user.setUserRole(userDto.getUserRole());

		return this.userToDto(this.userRepo.save(user));
	}

	@Override
	public UserDto getUserById(Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		return this.userToDto(this.userRepo.save(user));
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUserById(Long userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto, User.class);
		/*
		 * User user = new User(); user.setUserId(userDto.getUserId());
		 * user.setFirstName(userDto.getFirstName());
		 * user.setLastName(userDto.getLastName()); user.setMblNo(userDto.getMblNo());
		 * user.setEmailId(userDto.getEmailId());
		 * user.setCityNation(userDto.getCityNation());
		 * user.setPassword(userDto.getPassword());
		 * user.setUserRole(userDto.getUserRole());
		 */
		return user;

	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		 * UserDto userDto = new UserDto();
		 * userDto.setUserId(user.getUserId());
		 * userDto.setFirstName(user.getFirstName());
		 * userDto.setLastName(user.getLastName()); userDto.setMblNo(user.getMblNo());
		 * userDto.setEmailId(user.getEmailId());
		 * userDto.setCityNation(user.getCityNation());
		 * userDto.setPassword(user.getPassword());
		 * userDto.setUserRole(user.getUserRole());
		 */

		return userDto;
	}
}
