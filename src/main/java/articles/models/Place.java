package articles.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="place")
public class Place {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state", nullable = false)
    private String state;

    /*    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<User>();*/

    // --------------- Constructors -------------- //
    public Place() {
    }

    public Place(String city, String state) {
        this.city = city;
        this.state = state;
        //this.users = new ArrayList<>();
    }

    // -------------- To String -------------- //
    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
    // --------------- Setters -------------- //
    public void setId(long id) {
        this.id = id;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }/*
    public void setUsers(List<User> users) {
        this.users = users;
    }*/
    // --------------- Getters -------------- //
    public long getId() {
        return id;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    /*
    public List<User> getUsers() {
        return users;
    }*/
}
