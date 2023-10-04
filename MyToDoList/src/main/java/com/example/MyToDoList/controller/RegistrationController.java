package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.User;
import com.example.MyToDoList.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            model.addAttribute("my_message", "User already exists");
            return "registration";
        }

        user.setActive(true);
        userRepository.save(user);

        return "redirect:/login";
    }
}
