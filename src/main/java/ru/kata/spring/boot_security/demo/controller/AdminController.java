package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class AdminController {

    private UserServiceImpl userService;

    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("users", userService.foundUser(id));
        return "show";
    }

    @GetMapping("/admin/create_user")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllUser());
        return "new";
    }

    @PostMapping("/create_user")
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        user.setPassword(user.getPassword());
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/update_user")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.foundUser(id));
        model.addAttribute("roles", roleService.getAllUser());
        return "editor";
    }

    @PostMapping("/admin/{id}/update_user")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        user.setPassword(user.getPassword());
        userService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
