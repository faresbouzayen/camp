package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tunisie.camp.domain.Weather;
import tunisie.camp.dto.WeatherDTO;
import tunisie.camp.service.WeatherService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v/weathers")
public class WeatherController {
    private final WeatherService weather_service;
    private final ModelMapper not_mapper;

    private WeatherDTO toDto(Weather weather){
        return not_mapper.map(weather, WeatherDTO.class);
    }
    private Weather toEntity(WeatherDTO weatherDTO){
        return not_mapper.map(weatherDTO, Weather.class);
    }

}
