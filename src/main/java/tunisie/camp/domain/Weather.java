package tunisie.camp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Date sunriseTime;
    private Date sunsetTime;
    private double humidity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "campsite_id")
    private Campsite campsite;
}
