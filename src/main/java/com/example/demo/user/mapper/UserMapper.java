package com.example.demo.user.mapper;

import com.example.demo.user.dto.UserDto;
import com.example.demo.user.dto.UserPatchDto;
import com.example.demo.user.dto.UserPostDto;
import com.example.demo.user.dto.UserResponseDto;
import com.example.demo.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToUser(UserPostDto userPostDto);
    User userPatchDtoToUser(UserPatchDto userPatchDto);
    UserResponseDto userToUserResponseDto(User user);

    User userPostDtoToUser1(UserDto.UserPostDto userPostDto);
    User userPatchDtoToUser1(UserDto.UserPatchDto userPatchDto);
    UserDto.UserResponseDto userToUserResponseDto1(User user);
}
