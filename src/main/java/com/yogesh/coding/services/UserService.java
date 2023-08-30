package com.yogesh.coding.services;

import java.util.List;

import com.yogesh.coding.payloads.UserDto;

public interface UserService {
   UserDto createUser(UserDto userDto);
   
   UserDto updateUser(UserDto userDto,Integer userId);
   
   UserDto getUserById (Integer userId);
   
   List<UserDto>getAllUsers();
   
   
   void deleteUser(Integer userId);
   
   
   
}
