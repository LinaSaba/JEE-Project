package articles.models;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="trip")
public class Trip {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private long id;
    @Column(name = "cityA", nullable = false)
    private String cityA;
    @Column(name = "cityB", nullable = false)
    private String cityB;
    @Column(name = "time", nullable = false)
    private String time;

/*    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<User>();*/

    // --------------- Constructors -------------- //
    public Trip() {
    }


    public Trip(String cityA, String cityB, String time) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.time = time;
        //this.users = new ArrayList<>();
    }

    // -------------- To String -------------- //
    @Override
    public String toString() {
        return "Trip{" +
                "tripNb=" + id +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
    // --------------- Setters -------------- //
    public void setId(long id) {
        this.id = id;
    }
    public void setCityA(String cityA) {
        this.cityA = cityA;
    }
    public void setCityB(String cityB) {
        this.cityB = cityB;
    }
    public void setTime(String time) {
        this.time = time;
    }/*
    public void setUsers(List<User> users) {
        this.users = users;
    }*/
    // --------------- Getters -------------- //
    public long getId() {
        return id;
    }
    public String getCityA() {
        return cityA;
    }
    public String getCityB() {
        return cityB;
    }
    public String getTime() {
        return time;
    }/*
    public List<User> getUsers() {
        return users;
    }*/
}
