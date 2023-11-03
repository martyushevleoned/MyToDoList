package com.example.MyToDoList.controller;

import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {

        if (!registrationService.userDataIsCorrect(user.getUsername(), user.getPassword()))
            return "registration";

        if (registrationService.isUserExist(user))
            return "registration";

        registrationService.saveUser(user);

        return "redirect:/login";
    }
}
