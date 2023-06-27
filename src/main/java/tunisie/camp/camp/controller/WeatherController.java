package tunisie.camp.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.camp.domain.Weather;
import tunisie.camp.camp.dto.WeatherDTO;
import tunisie.camp.camp.services.WeatherService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@PreAuthorize("isAuthenticated()")
@AllArgsConstructor
@RestController
public class WeatherController {
    private final WeatherService weather_service;
    private final ModelMapper not_mapper;

    private WeatherDTO toDto(Weather weather){
        return not_mapper.map(weather, WeatherDTO.class);
    }
    private Weather toEntity(WeatherDTO weatherDTO){
        return not_mapper.map(weatherDTO, Weather.class);
    }

    @GetMapping
    public List<WeatherDTO> getWeathers(){
        var weather_list = StreamSupport
                .stream(weather_service.findAllWeathers().spliterator(), false)
                .collect(Collectors.toList());
        return weather_list
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public WeatherDTO postWeather(@Validated @RequestBody WeatherDTO weather_dto){
        var entity = toEntity(weather_dto);
        var weather = weather_service.addWeather(entity);
        return toDto(weather);
    }

    @PutMapping("/{id}")
    public void putWeather(@PathVariable("id") UUID id, @Validated @RequestBody WeatherDTO weather_dto){
        var weather_domain = toEntity(weather_dto);
        weather_service.updateWeather(id,weather_domain);
    }

    @DeleteMapping("/{id}")
    public void deleteWeatherById(@PathVariable("id") UUID id){
        weather_service.removeWeatherById(id);
    }
}
