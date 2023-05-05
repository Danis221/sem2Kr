package ru.itis.kr1_oris.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.kr1_oris.model.User;

@Data
@Builder
public class UserResponseDto {

    private Integer id;

    private String name;

    private String email;

    public static UserResponseDto fromEntity(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
