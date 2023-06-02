package tunisie.camp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tunisie.camp.domain.Weather;
import tunisie.camp.repository.WeatherRepository;

import java.util.NoSuchElementException;

@Service
public class WeatherService {
    private final WeatherRepository weather_repository;
    @Autowired
    public WeatherService(WeatherRepository weather_repository){
        this.weather_repository = weather_repository;
    }
    public Weather addWeather(Weather weather){
        return weather_repository.save(weather);
    }
    public Iterable<Weather> findAllWeathers(){
        return weather_repository.findAll();
    }
    public Weather findWeatherById(long weather_id){
        return findOrThrow(weather_id);
    }
    public void updateWeather(long weather_id, Weather weather){
        findOrThrow(weather_id);
        weather_repository.save(weather);
    }
    private void removeWeatherById(long weather_id){
        weather_repository.deleteById(weather_id);
    }
    private Weather findOrThrow(final long weather_id){
        return weather_repository
                .findById(weather_id)
                .orElseThrow(
                        () -> new NoSuchElementException("Weather wasn't found by id" + weather_id)
                );
    }

}
