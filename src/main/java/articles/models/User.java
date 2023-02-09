package articles.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
public class User implements UserDetails {
    /*
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private long id;*/
    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "dream_destination", nullable = false)
    private String dream_destination;
    @Column(name = "admin", nullable = false)
    private boolean admin;
/*
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Trip> trips = new ArrayList<>();*/

    public User() {
        this.prenom = "prenom";
        this.email = "email";
        this.dream_destination = "dream_destination";
        this.admin = false;
    }

    public User(String username, String password, String prenom, String email, String dream_destination, boolean admin ) {
        this.username = username;
        this.password = password;
        this.prenom = prenom;
        this.email = email;
        this.dream_destination = dream_destination;
        this.admin = admin;
    }

    // -------------- To String -------------- //
    @Override
    public String toString() {
        return "User{" +
                "login=" + username +
                ",password=" + password +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dream_destination='" + dream_destination + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }

    // --------------- Setters -------------- //
    /*public void setId(long id) {
        this.id = id;
    }*/
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDream_destination(String dream_destination) {
        this.dream_destination = dream_destination;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    // --------------- Getters -------------- //
    /*public long getId() {
        return id;
    }*/
    public String getPrenom() {
        return prenom;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getDream_destination() {
        return dream_destination;
    }
    public boolean isAdmin() {
        return admin;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}

