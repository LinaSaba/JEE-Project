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
    public String submitUser(@ModelAttribute("user") User user) {
        System.out.println("euuuh"+user.toString());
        userService.save(user);
        System.out.println(user);
        return "user_added";
    }
    @RequestMapping(value = "/delete/{id}")
    private String deleteUser(@PathVariable(name = "id") int id){
        System.out.println("id : "+id);
        userService.delete(userService.findById((long)(id)).get());
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
        User user = userService.findById((long)(id)).get();
        model.addAttribute("user", user);
        return "addUser";
    }

}
