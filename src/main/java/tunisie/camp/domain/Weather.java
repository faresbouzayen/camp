package tunisie.camp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
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
