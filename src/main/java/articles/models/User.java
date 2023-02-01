package articles.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Participant")
public class User {
    @Id
    @GeneratedValue(generator = "incerement")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "login")
    private String login;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "dream_destination", nullable = false)
    private String dream_destination;
    @Column(name = "admin", nullable = false)
    private boolean admin;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Trip> trips = new ArrayList<>();

    public User() {
    }
    public User(String login, String prenom, String email, String dream_destination, boolean admin) {
        this.login = login;
        this.prenom = prenom;
        this.email = email;
        this.dream_destination = dream_destination;
        this.admin = admin;
    }

    // -------------- To String -------------- //
    @Override
    public String toString() {
        return "User{" +
                "login=" + login +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", dream_destination='" + dream_destination + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }

    // --------------- Setters -------------- //

    public void setLogin(String login) {
        this.login = login;
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
    public String getPrenom() {
        return prenom;
    }
    public String getLogin() {
        return login;
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

}

