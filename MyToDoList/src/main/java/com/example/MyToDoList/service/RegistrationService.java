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

        if (username.length() < 2)
            return false;

        if (password.length() < 2)
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
