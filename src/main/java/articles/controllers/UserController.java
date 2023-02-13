package articles.controllers;

import articles.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import articles.models.User;
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String getUser(Model model) {
        model.addAttribute("users",userService.findAll());
        return "user";
    }
    @GetMapping("/adduser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "adduser";
    }
    @PostMapping("/adduser")
    public String submitUser(@ModelAttribute("user") User user, Model model) {
        System.out.println("euuuh"+user.toString());
        userService.save(user);
        System.out.println(user);
        model.addAttribute("users",userService.findAll());
        return "redirect:/users";
    }
    @RequestMapping(value = "/deleteuser/{username}")
    private String deleteUser(@PathVariable(name = "username") String username){
        System.out.println("username : "+username);
        userService.delete(userService.findByUsername((String)(username)));
        return "redirect:/users";
    }
    @GetMapping("/updateuser/{username}")
    public String updateForm(@PathVariable("username") String username, Model model) {
        User user = userService.findByUsername((String)(username));
        model.addAttribute("user", user);
        return "adduser";
    }

}