package articles.controllers;

import articles.models.Trip;
import articles.models.User;
import articles.repository.UserRepository;
import articles.security.SecurityUserDetailsService;
import articles.services.TripService;
import articles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
public class LoginController {
    public boolean update = false;
    @Autowired private UserRepository userRepository;
    @Autowired private SecurityUserDetailsService userDetailsManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (username == "anonymousUser") {
            username = "login";
        }
        model.addAttribute("username", username);
        return "index";
    }
    @GetMapping("/{username}")
    public String indexLogged(@PathVariable String username, Model model) {
        System.out.println("____username____");
        System.out.println(username);
        model.addAttribute("username", username);
        return "index";
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpSession session) {
        session.setAttribute(
                "error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION")
        );
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("____username2____");
        return "register";
    }
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public String addUser(@RequestParam Map<String, String> body, Model model) {
        System.out.println("__________");
        System.out.println(update);
        if (update) {
            if (userRepository.findUserByEmail(body.get("email")).isEmpty()) {
                userRepository.delete(userRepository.findUserByEmail(body.get("email")).orElseThrow());
            }
        }
        if (!userRepository.findUserByEmail(body.get("email")).isEmpty()) {
            model.addAttribute("popup", "You seem to be already have an account with this email, do you want to update your informations ?");
            model.addAttribute("update", true);
            update = true;
            return null;
        }
        if (userRepository.findUserByUsername(body.get("username")).isEmpty()) {
            User user = new User();
            user.setUsername(body.get("username"));
            user.setPassword(passwordEncoder.encode(body.get("password")));
            user.setEmail(body.get("email"));
            if (body.get("prenom") != null) {
                user.setPrenom(body.get("prenom"));
            }
            if (body.get("dream_destination") != null) {
                user.setDream_destination(body.get("dream_destination"));
            }
            userDetailsManager.createUser(user);
            return "redirect:/"+body.get("username");
        }
        model.addAttribute("popup", "This username is already taken, please choose another one.");
        return null;
    }

    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
}
