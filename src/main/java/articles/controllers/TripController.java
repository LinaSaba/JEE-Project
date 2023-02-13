package articles.controllers;

import articles.models.Trip;
import articles.models.User;
import articles.services.TripService;
import articles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.apache.logging.log4j.util.Strings.isEmpty;


@Controller
public class TripController {
    @Autowired
    TripService tripService;

    @Autowired
    UserService userService;

    @GetMapping("/trips")
    public String getTrip(Model model) {
        model.addAttribute("trips", tripService.findAll());
        return "trip";
    }

    @GetMapping("/addtrip")
    public String addTrip(Model model) {
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        return "addtrip";
    }

    @GetMapping("/searchtrip")
    public String searchTrip(String CityA, Model model) {
        List<Trip> trips = tripService.findByCityA(CityA);
        System.out.println("A" + CityA + "trips" + trips);

        if (trips.isEmpty()) {
            return "notrips";
        }
        model.addAttribute("trips", trips);
        model.addAttribute("CityA", CityA);
        return "searchtrip";
    }
    @RequestMapping( "/searchtrip2")
    public String addtrip(@RequestParam(value = "citya", required = true) String citya,
                          @RequestParam(value = "cityb", required = true) String cityb, Model model)
    {
        List<Trip> trips = tripService.findByCityAAndCityB(citya, cityb);

        System.out.println(trips);
        //System.out.println(userRepository.findUserByEmail(body.get("email")));
        System.out.println("__________");
        model.addAttribute("trips", trips);
    return "looktrip";
    }
    public String subscribeTrip( String CityA, String CityB, Model model) {
        List<Trip> trips = tripService.findByCityAAndCityB(CityA, CityB);
        System.out.println("A"+CityA+"B"+CityB+"trips"+trips);
        if (trips.isEmpty()){
            return "notrips";
        }
        model.addAttribute("trips", trips);
        return "looktrip";
    }

    @GetMapping("/looktrip/{id}")
    public String looktrip(@PathVariable(name = "id") int id, Model model) {
        Trip trip = tripService.findById((long)(id)).get();
        List<Trip> trips = new ArrayList<>();
        trips.add(trip);
        model.addAttribute("trip", trip);
        model.addAttribute("trips", trips);
        User user = new User();
        model.addAttribute("user", user);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        if (username == "anonymousUser") {
            return "redirect:/adduser";
        }
        else {
            System.out.println("username"+username);
            System.out.println(userService.findByUsername(username));
            user = userService.findByUsername((username));
            user.addTrip(trip);
            System.out.println("username"+user);
            userService.save(user);
            return "redirect:/users";
        }

    }

    @PostMapping("/addtrip")
    public String submitTrip(@ModelAttribute("trip") Trip trip, Model model) {
        tripService.save(trip);
        System.out.println(trip);
        model.addAttribute("trips",tripService.findAll());
        return "redirect:/trips";
    }
    @RequestMapping(value = "/delete/{id}")
    private String deleteTrip(@PathVariable(name = "id") int id){
        System.out.println("id : "+id);
        tripService.delete(tripService.findById((long)(id)).get());
        return "redirect:/trips";
    }

    @GetMapping("/updatetrip/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        Trip trip = tripService.findById((long)(id)).get();
        model.addAttribute("trip", trip);
        return "addtrip";
    }

}
