package articles.models;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email", nullable = false, unique=true)
    private String email;
    @Column(name = "dream_destination")
    private String dream_destination;
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Trip> trips = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();

    public List<Trip> getTrips() {
        return trips;
    }
    public void addTrip(Trip trip)
    {
        this.trips.add(trip);
        trip.getUsers().add(this);
    }

    public User() {
        this.prenom = "prenom";
        this.email = "email";
        this.dream_destination = "dream_destination";
        this.enabled = true;
    }

    public User(String username, String password, String prenom, String email, String dream_destination, boolean enabled) {
        this.username = username;
        this.password = password;
        this.prenom = prenom;
        this.email = email;
        this.dream_destination = dream_destination;
        this.enabled = enabled;
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
                ", enabled='" + enabled + '\'' +
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
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // --------------- Getters -------------- //
    /*public long getId() {
        return id;
    }*/
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public String getDream_destination() {
        return dream_destination;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

