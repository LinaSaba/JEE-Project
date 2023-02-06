package articles.controllers;

import articles.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import articles.models.Trip;


@Controller
public class TripController {
    @Autowired
    TripService tripService;
    @GetMapping("/trips")
    public String getTrip(Model model) {
        model.addAttribute("trips",tripService.findAll());
        return "trip";
    }
    @GetMapping("/addtrip")
    public String addTrip(Model model){
        Trip trip = new Trip();
        model.addAttribute("trip", trip);
        return "addtrip";
    }
    @PostMapping("/addtrip")
    public String submitTrip(@ModelAttribute("trip") Trip trip) {
        System.out.println("euuuh"+trip.toString());
        tripService.save(trip);
        System.out.println(trip);
        return "trip_added";
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
        return "addEvent";
    }

}
