package articles.repository;

import org.springframework.data.repository.CrudRepository;
import articles.models.User;

public interface UserCrUD extends CrudRepository<User, Long>{
}
