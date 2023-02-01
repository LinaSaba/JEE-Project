package articles.repository;

import articles.models.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripCrUD extends CrudRepository<Trip, Long> {
}
