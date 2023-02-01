package articles.services;

import articles.models.Trip;
import articles.repository.TripCrUD;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TripService {
    @Autowired
    private TripCrUD repository;

    public List<Trip> findAll() {
        List<Trip> trips = (List<Trip>) repository.findAll();
        return trips;
    }

    public void save(Trip trip) {
        repository.save(trip);
    }

    public Optional<Trip> findById(Long id) {
        return repository.findById(id);
    }

    public void delete(Trip trip) {
        repository.delete(trip);
    }

}
