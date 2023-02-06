package articles.repository;

import articles.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripCrUD extends CrudRepository<Trip, Long> {
}
