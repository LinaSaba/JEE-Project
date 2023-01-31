package articles.controllers;

import articles.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    String connexionState;

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("connexionState", connexionState);
        model.addAttribute("newLogin", new Login());

        return "login";
    }

    @PostMapping("/login")
    public String connect(@ModelAttribute Login newLogin) {
        connexionState = "Successfully connected";

        return "redirect:login";
    }
}
