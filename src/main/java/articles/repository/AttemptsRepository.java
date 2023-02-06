package articles.repository;

import articles.models.Attempts;
import articles.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttemptsRepository extends CrudRepository<User, Long> {
    Optional<Attempts> findAttemptsByUsername(String username);
}
