package com.example.SortRace.controller;

import com.example.SortRace.helper.mapper.user.RegisterUserDto;
import com.example.SortRace.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.ServiceNotFoundException;

@Controller
@RequestMapping("/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto){
        try{
            return ResponseEntity.ok().body(userService.register(registerUserDto));
        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
