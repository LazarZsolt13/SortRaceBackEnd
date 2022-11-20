package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.user.RegisterUserDto;

public interface UserService {
    Boolean register(RegisterUserDto registerUserDto);
    /**
     * This function add new user to the database.
     */

}
