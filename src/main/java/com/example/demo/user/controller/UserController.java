package com.example.demo.user.controller;

import com.example.demo.user.dto.UserPostDto;
import com.example.demo.user.dto.UserPatchDto;
import com.example.demo.user.dto.UserResponseDto;
import com.example.demo.user.entity.User;
import com.example.demo.user.mapper.UserMapper;
import com.example.demo.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

//@RestController
//@RequestMapping("v1/users")
//@Validated
public class UserController {
    private final UserService usersService;
    private final UserMapper mapper;

    public UserController(UserService usersService, UserMapper mapper) {
        this.usersService = usersService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postUser(@RequestBody UserPostDto userDto) {
        User user = mapper.userPostDtoToUser(userDto);

        User response = usersService.createUser(user);

        return new ResponseEntity<>(mapper.userToUserResponseDto(response),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{user-id}")
    public ResponseEntity patchUser(
            @PathVariable("user-id") @Positive long usersId,
            @Valid @RequestBody UserPatchDto usersPatchDto) {
        usersPatchDto.setUserId(usersId);

        User response =
                usersService.updateUser(mapper.userPatchDtoToUser(usersPatchDto));

        return new ResponseEntity<>(mapper.userToUserResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUser(
            @PathVariable("user-id") @Positive long usersId) {
        User response = usersService.findUser(usersId);
        return new ResponseEntity<>(mapper.userToUserResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        List<User> users = usersService.findUsers();
        List<UserResponseDto> response =
                users.stream()
                        .map(user -> mapper.userToUserResponseDto(user))
                        .collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser(
            @PathVariable("user-id") @Positive long usersId) {
        System.out.println("# delete user");
        usersService.deleteUser(usersId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
