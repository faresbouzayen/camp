package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Weather;
@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
}
