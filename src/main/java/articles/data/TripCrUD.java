package articles.data;

import articles.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface TripCrUD extends CrudRepository<Trip, Long> {
}
