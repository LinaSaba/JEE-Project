package articles.controllers;

import articles.models.Trip;
import articles.models.User;
import articles.services.TripService;
import articles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {

    public String connexionState;
    public List allUsers = new ArrayList();

    @Autowired
    UserService userDAO;

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("connexionState", connexionState);
        User userTest = new User("username", "password", "prenom", "email", "dream_destination", true);
        model.addAttribute("newLogin", userTest);
        userDAO.save(userTest);

        return "login";
    }

    @PostMapping("/login")
    public String connect(@ModelAttribute User newLogin) {

        allUsers = userDAO.findAll();
        allUsers.forEach((user) -> {
            System.out.println("***************user");
            System.out.println(user);
        });

        connexionState = "Successfully connected";

        return "redirect:login";
    }
}
