package tunisie.camp.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tunisie.camp.domain.Weather;
import tunisie.camp.dto.WeatherDTO;
import tunisie.camp.service.WeatherService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @PutMapping("/{weather_id}")
    public void putWeather(@PathVariable("weather_id") long weather_id, @Validated @RequestBody WeatherDTO weather_dto){
        if (weather_id != weather_dto.getWeather_id()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"weather id not found");
        var weather_domain = toEntity(weather_dto);
        weather_service.updateWeather(weather_id,weather_domain);
    }

    @DeleteMapping("/{weather_id}")
    public void deleteWeatherById(@PathVariable("weather_id") long weather_id){
        weather_service.removeWeatherById(weather_id);
    }
}
