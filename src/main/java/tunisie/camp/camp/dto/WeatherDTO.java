package tunisie.camp.camp.dto;

import lombok.*;
import tunisie.camp.camp.domain.Campsite;

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
