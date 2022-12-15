package com.example.SortRace.controller;

import com.example.SortRace.config.TokenAuthenticationService;
import com.example.SortRace.config.UserAuthenticationProvider;
import com.example.SortRace.helper.mapper.user.LoginUserDto;
import com.example.SortRace.helper.mapper.user.RegisterUserDto;
import com.example.SortRace.service.UserService;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
@CrossOrigin
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final TokenAuthenticationService tokenAuthenticationService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto){
        try{
            return ResponseEntity.ok().body(userService.register(registerUserDto));
        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto, HttpServletResponse httpServletResponse){ // fogalmam sincs hogy mi ez.
        try{
            UsernamePasswordAuthenticationToken usr = new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(),
                    loginUserDto.getPassword());

            Authentication auth = userAuthenticationProvider.authenticate(usr);
            tokenAuthenticationService.authenticationResponse(httpServletResponse, auth);

            SecurityContextHolder.getContext().setAuthentication(auth);

            return ResponseEntity.ok().body(userService.getCurrentUserDto());

        }catch (ServiceException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
