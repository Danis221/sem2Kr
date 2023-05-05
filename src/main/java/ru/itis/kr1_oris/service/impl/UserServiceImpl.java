package ru.itis.kr1_oris.service.impl;


import lombok.AllArgsConstructor;
import net.bytebuddy.utility.RandomString;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.kr1_oris.dto.CreateUserRequestDto;
import ru.itis.kr1_oris.dto.UserResponseDto;
import ru.itis.kr1_oris.model.User;
import ru.itis.kr1_oris.repository.UserRepository;
import ru.itis.kr1_oris.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Override
    public UserResponseDto create(CreateUserRequestDto createUserDto) {
        String encodedPassword = encoder.encode(createUserDto.getPassword());
        User user = User.builder()
                .name(createUserDto.getName())
                .email(createUserDto.getEmail())
                .password(encodedPassword)
                .build();

        userRepository.save(user);

        return UserResponseDto.fromEntity(user);
    }
}
