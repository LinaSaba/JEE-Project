package articles.repository;

import articles.models.Trip;
import articles.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCrUD extends CrudRepository<User, Long>{
    User findByUsername(String username);

}
