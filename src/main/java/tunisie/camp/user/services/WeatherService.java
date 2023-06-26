package tunisie.camp.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.user.domain.Weather;
import tunisie.camp.user.repository.WeatherRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class WeatherService {
    @Autowired
    private final WeatherRepository weather_repository;

    public WeatherService(WeatherRepository weather_repository){
        this.weather_repository = weather_repository;
    }
    public Weather addWeather(Weather weather){
        return weather_repository.save(weather);
    }
    public Iterable<Weather> findAllWeathers(){
        return weather_repository.findAll();
    }
    public Weather findWeatherById(UUID id){
        return findOrThrow(id);
    }
    public void updateWeather(UUID id, Weather weather){
        findOrThrow(id);
        weather_repository.save(weather);
    }
    public void removeWeatherById(UUID id){
        weather_repository.deleteById(id);
    }
    private Weather findOrThrow(final UUID id){
        return weather_repository
                .findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Weather wasn't found by id" + id)
                );
    }


}
