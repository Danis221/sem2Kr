package ru.itis.kr1_oris.service;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import ru.itis.kr1_oris.dto.CityForWeatherDto;
import ru.itis.kr1_oris.dto.UserHistoryResponseDto;
import ru.itis.kr1_oris.filter.JwtAuthentication;

public interface UserHistoryService {
    UserHistoryResponseDto create(CityForWeatherDto historyDtoDto);
}
