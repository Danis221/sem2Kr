package ru.itis.kr1_oris.service;


import ru.itis.kr1_oris.dto.CreateUserRequestDto;
import ru.itis.kr1_oris.dto.UserResponseDto;

public interface UserService {
    UserResponseDto create(CreateUserRequestDto userDto);
}
