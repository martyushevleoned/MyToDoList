package com.example.MyToDoList.service;

import com.example.MyToDoList.model.entity.User;
import com.example.MyToDoList.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public boolean userDataIsCorrect(String username, String password) {

        int minTextLength = 2;
        int maxTextLength = 40;

        if (minTextLength > username.length() ||  username.length() > maxTextLength)
            return false;

        if (minTextLength > password.length() || password.length() > maxTextLength)
            return false;

        return true;
    }
    public boolean isUserExist(User user) {

        User userDb = userRepository.findByUsername(user.getUsername());
        return userDb != null;
    }

    public void saveUser(User user) {
        user.setActive(true);
        userRepository.save(user);
    }
}
