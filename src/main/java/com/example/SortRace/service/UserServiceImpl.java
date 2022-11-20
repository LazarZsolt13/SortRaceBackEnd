package com.example.SortRace.service;

import com.example.SortRace.helper.mapper.user.RegisterUserDto;
import com.example.SortRace.helper.mapper.user.UserMapper;
import com.example.SortRace.helper.mapper.user.UserResponseDto;
import com.example.SortRace.model.UserEntity;
import com.example.SortRace.repository.UserRepository;
import com.example.SortRace.util.Utility;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final Utility utility;
    @Override
    public Boolean register(RegisterUserDto registerUserDto) {
        UserEntity userEntity;
        if (registerUserDto.getPassword().length()<6){
            throw new ServiceException("The password is to short(minim 6 character).");
        }
        userEntity = UserMapper.toRegisterEntity(registerUserDto);
        if (userEntity.getFirstName().isEmpty() || userEntity.getLastName().isEmpty() || userEntity.getNickName().isEmpty() ||
            userEntity.getEmail().isEmpty() || userEntity.getPassword().isEmpty()){
            throw new ServiceException("Please fill all filds!");
        }
        userRepository.save(userEntity);


        return true;
    }

    @Override
    public UserResponseDto getCurrentUserDto() {
        return UserMapper.toUserResponseDto(utility.getCurrentUser());
    }


}
