package com.auth.security.service;

import com.auth.security.model.User;
import com.auth.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User login(String email,String password){
        User user = userRepository.findByEmail(email);
        if(user==null){
            return null;
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

}
