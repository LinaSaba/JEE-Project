package articles.repository;

import articles.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCrUD extends CrudRepository<User, Long>{
}
