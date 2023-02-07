package articles.repository;

import articles.models.Attempts;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttemptsRepository extends CrudRepository<Attempts, Long> {
    Optional<Attempts> findAttemptsByUsername(String username);
}
