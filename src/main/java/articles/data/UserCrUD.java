package articles.data;

import org.springframework.data.repository.CrudRepository;
import articles.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserCrUD extends CrudRepository<User, Long> {
}
