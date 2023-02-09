package articles.services;

import articles.models.Attempts;
import articles.repository.AttemptsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttemptsService {

    @Autowired
    private AttemptsRepository repository;

    public List<Attempts> findAll() {
        List<Attempts> attempts = (List<Attempts>) repository.findAll();
        return attempts;
    }

    public void save(Attempts attempts) {
        repository.save(attempts);
    }

    /*public Optional<Attempts> findById(Long id) {
        return repository.findById(id);
    }*/

    public void delete(Attempts attempts) {
        repository.delete(attempts);
    }

    public Optional<Attempts> findAttemptsByUsername(String username) {
        return repository.findAttemptsByUsername(username);
    }

}
