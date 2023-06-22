package tunisie.camp.user.service.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tunisie.camp.user.service.domain.Weather;
import tunisie.camp.user.service.dto.WeatherDTO;
import tunisie.camp.user.service.WeatherService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
