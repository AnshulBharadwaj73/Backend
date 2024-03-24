package com.example.demo.Service;

import com.example.demo.Dto.LoginDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Repo.LoginMessage;

public interface UserService {

    String addUser(UserDto userDto);
    String loginUser(LoginDto loginDto);

}
