package tunisie.camp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import tunisie.camp.domain.Weather;

import java.util.UUID;

@Repository
@RepositoryRestResource(path="weathers")
public interface WeatherRepository extends CrudRepository<Weather, UUID> {
}
