package tunisie.camp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
