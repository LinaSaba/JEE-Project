package articles.controllers;

import ensg.tsi.jee_project.servingwebcontent.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login") {
        
        return "loginPage";
    }

    @PostMapping("/login")
    Public String connect(@ModelAttribute Login login) {
        return "redirect:login";
    }
}
