package com.example.SortRace.helper.mapper.user;

import com.example.SortRace.model.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper{

    public static UserEntity toEntity(UserDto userDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();


        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setNickName(userDto.getNickName());
        userEntity.setImage(userDto.getImage());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setActive(userDto.getActive());

        return userEntity;
    }

    public static List<UserEntity> toEntityList(List<UserDto> userDtos){
        return userDtos.stream().map(UserMapper::toEntity).collect(Collectors.toList());
    }

    public static UserDto toDto (UserEntity userEntity){
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setNickName(userEntity.getNickName());
        dto.setImage(userEntity.getImage());
        dto.setEmail(userEntity.getEmail());
        dto.setPassword(userEntity.getPassword());
        dto.setActive(userEntity.getActive());


        return dto;
    }

    public static List<UserDto> toDtoList(List<UserEntity> userEntities){
        return userEntities.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    public static UserEntity toRegisterEntity(RegisterUserDto userDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setNickName(userDto.getNickName());
        userEntity.setImage("");
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        //Abban az esetben ha mar kesz a vissza igazolo email et alittsd be falsera
        userEntity.setActive(true);

        return userEntity;
    }

}
