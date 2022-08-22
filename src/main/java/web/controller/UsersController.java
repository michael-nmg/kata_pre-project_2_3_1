package web.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @ModelAttribute("table")
    public List<User> allUsers() {
        return userService.getUsers();
    }

    @GetMapping("/")
    public String getAllUsers(ModelMap model) {
        model.addAttribute("newUser", new User());
        return "users";
    }

    @PostMapping("/")
    public String setNewUser(@ModelAttribute("newUser") User user) {
        userService.setUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/")
    public String deleteUser(@RequestParam("name") Long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("userByID", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String patchUser(@ModelAttribute("userByID") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
