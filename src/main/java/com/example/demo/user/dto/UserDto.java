package com.example.demo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserPostDto{
        private String id;

        private String password;

        private String name;

        private String phone;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserPatchDto{
        private long userId;

        private String id;

        private String password;

        private String name;

        private String phone;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserResponseDto{
        private long userId;

        private String id;

        private String password;

        private String name;

        private String phone;
    }
}
