package articles.security;

import articles.models.MyUserDetails;
import articles.models.User;
import articles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));
        //MyUserDetails myUserDetails = new MyUserDetails(user);
        return new MyUserDetails(user);
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void findUserByEmail(String email) {
        
    }
}