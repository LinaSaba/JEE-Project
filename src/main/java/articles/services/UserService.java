package articles.services;

import articles.models.User;
import articles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    public void save(User user) {
        repository.save(user);
    }

    /*public Optional<User> findById(Long id) {
        return repository.findById(id);
    }*/

    public void delete(User user) {
        repository.delete(user);
    }

    public Optional<User> findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }


}
