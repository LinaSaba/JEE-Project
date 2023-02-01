package articles;

import articles.models.Trip;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Trip trip1 = new Trip(123,"Agadir", "Casablanca", "9h");
    }

}