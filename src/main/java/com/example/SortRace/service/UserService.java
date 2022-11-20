package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.user.RegisterUserDto;
import com.example.SortRace.helper.mapper.user.UserResponseDto;

public interface UserService {
    Boolean register(RegisterUserDto registerUserDto);
    /**
     * This function add new user to the database.
     */
    UserResponseDto getCurrentUserDto();
    /**
     * Returning the currently logged user
     */
}
