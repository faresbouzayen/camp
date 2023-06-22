package tunisie.camp.user.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tunisie.camp.user.service.domain.Weather;

import java.util.UUID;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, UUID> {
}
