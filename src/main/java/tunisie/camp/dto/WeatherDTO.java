package tunisie.camp.dto;

import lombok.*;
import tunisie.camp.domain.Campsite;
import java.util.Date;

@Getter
@Setter
public class WeatherDTO {
    private long weather_id;
    private double temperature;
    private double precipitation;
    private double windSpeed;
    private Date forecastDate;
    private Campsite campsiteInfo;
    private Date sunriseTime;
    private Date sunsetTime;
    private double humidity;
}
