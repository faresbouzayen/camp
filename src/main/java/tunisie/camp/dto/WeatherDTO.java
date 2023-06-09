package tunisie.camp.dto;

import lombok.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tunisie.camp.domain.Campsite;
import tunisie.camp.domain.Weather;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class WeatherDTO {
    private UUID id;
    private double temperature;
    private double precipitation;
    private double windSpeed;
    private Date forecastDate;
    private Campsite campsiteInfo;
    private Date sunriseTime;
    private Date sunsetTime;
    private double humidity;

    }
