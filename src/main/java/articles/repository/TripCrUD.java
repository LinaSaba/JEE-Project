package articles.repository;

import articles.models.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripCrUD extends CrudRepository<Trip, Long> {
    List<Trip> findByCityA(String CityA);

    List<Trip> findByCityAAndCityB(String CityA, String cityB);
}
