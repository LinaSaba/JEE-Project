package articles.data;

import org.springframework.data.repository.CrudRepository;
import articles.models.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserCrUD extends CrudRepository<User, Long>{
}
