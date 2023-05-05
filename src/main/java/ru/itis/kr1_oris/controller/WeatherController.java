package ru.itis.kr1_oris.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kr1_oris.dto.CityForWeatherDto;
import ru.itis.kr1_oris.service.UserHistoryService;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final UserHistoryService historyService;

    @PostMapping("get/weather")
    private ResponseEntity<String> getDegrees(@RequestBody CityForWeatherDto cityForWeatherDto)   {
        return ResponseEntity.ok("Температура:" + historyService.create(cityForWeatherDto).getDegreesCelsius());
    }
}
