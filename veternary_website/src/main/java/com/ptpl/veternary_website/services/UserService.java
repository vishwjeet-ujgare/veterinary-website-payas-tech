package com.ptpl.veternary_website.services;

import com.ptpl.veternary_website.payloads.UserDto;
import java.util.List;

public interface UserService {
	UserDto createUser(UserDto userDto);

	UserDto updateUser(UserDto userDto, Long userId);

	UserDto getUserById(Long userId);

	List<UserDto> getAllUsers();
	
	void deleteUserById(Long userId);
}
