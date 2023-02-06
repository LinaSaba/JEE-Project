package articles.repository;

import org.springframework.data.repository.CrudRepository;
import articles.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
