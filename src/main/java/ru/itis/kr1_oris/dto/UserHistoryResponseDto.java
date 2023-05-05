package ru.itis.kr1_oris.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.kr1_oris.model.User;
import ru.itis.kr1_oris.model.UserHistory;

@Data
@Builder
public class UserHistoryResponseDto {

    private String city;

    private Double degreesCelsius;


    public static UserHistoryResponseDto fromEntity(UserHistory history) {
        return UserHistoryResponseDto.builder()
                .city(history.getCity())
                .degreesCelsius(history.getDegreesCelsius())
                .build();
    }
}
