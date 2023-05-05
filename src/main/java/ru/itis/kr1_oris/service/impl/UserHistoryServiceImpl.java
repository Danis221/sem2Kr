package ru.itis.kr1_oris.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import ru.itis.kr1_oris.aspect.Loggable;
import ru.itis.kr1_oris.dto.CityForWeatherDto;
import ru.itis.kr1_oris.dto.UserHistoryResponseDto;
import ru.itis.kr1_oris.model.User;
import ru.itis.kr1_oris.model.UserHistory;
import ru.itis.kr1_oris.repository.UserHistoryRepository;
import ru.itis.kr1_oris.repository.UserRepository;
import ru.itis.kr1_oris.service.UserHistoryService;
import ru.itis.kr1_oris.util.WeatherUtil;

@Service
@RequiredArgsConstructor
public class UserHistoryServiceImpl implements UserHistoryService {

    private final UserHistoryRepository userHistoryRepository;

    private final UserRepository userRepository;
    private final WeatherUtil weatherUtil;
    @Loggable
    @Override
    public UserHistoryResponseDto create(CityForWeatherDto historyDtoDto) {

         Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
         String email = (String) authentication.getPrincipal();

         User currentUser = (userRepository.findByEmail(email)
                 .orElseThrow(() -> new UsernameNotFoundException("User with emai"+email+"not found")));

         UserHistory userHistory = UserHistory.builder()
                .city(historyDtoDto.getCity())
                .user(currentUser)
                .degreesCelsius(weatherUtil.getTemperature(historyDtoDto.getCity()))
                .build();

         userHistoryRepository.save(userHistory);

         return UserHistoryResponseDto.fromEntity(userHistory);
    }
}
