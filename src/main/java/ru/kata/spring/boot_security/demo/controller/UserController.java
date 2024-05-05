package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;


@Controller
//@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService; 
    }

    @GetMapping("/user")
    public String showUserPage(Principal principal, Model model) {
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "user";
    }

//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("users", userService.getAllUser());
//        return "index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("users", userService.foundUser(id));
//        return "show";
//    }
//
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("users") User user) {
//        return "new";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("users") @Valid User user,
//                         BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "new";
//
//        userService.save(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("users", userService.foundUser(id));
//        return "editor";
//    }
//
//    @PostMapping("/{id}/edit")
//    public String update(@ModelAttribute("users") @Valid User user, BindingResult bindingResult,
//                         @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors())
//            return "editor";
//
//        userService.updateUser(id, user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users";
//    }

}
