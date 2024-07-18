package com.auth.security.controller;

import com.auth.security.dto.req.LoginRequestDto;
import com.auth.security.dto.res.SuccessResponse;
import com.auth.security.model.User;
import com.auth.security.repositories.UserRepository;
import com.auth.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<SuccessResponse> saveDetails(@RequestBody User user){
        userService.saveUser(user);
        SuccessResponse successResponse = new SuccessResponse(
                HttpStatus.CREATED,
                201,
                "User Created Successful",
                Optional.ofNullable(user)
        );
        return new ResponseEntity<>(successResponse,HttpStatus.CREATED) ;
    }

    @GetMapping("/users")
    public ResponseEntity<SuccessResponse> getUsers(){
        List<User> users = userService.getUsers();
        SuccessResponse successResponse = new SuccessResponse(
                HttpStatus.OK,
                200,
                "Every Users",
                Optional.ofNullable(users)
        );
        return  new ResponseEntity<>(successResponse,HttpStatus.OK);
    }

    @GetMapping( "/{id}")
    public  ResponseEntity<SuccessResponse> getUser(@PathVariable("id") int id){
       Optional<User> user = userRepository.findById(id);
        SuccessResponse successResponse = new SuccessResponse(
                HttpStatus.OK,
                200,
                "User Found",
                Optional.ofNullable(user)
        );
        return new  ResponseEntity<>(successResponse,HttpStatus.OK) ;
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse> login(@RequestBody LoginRequestDto data){
        User user = userService.login(data.getEmail(),data.getPassword());
        SuccessResponse successResponse = new SuccessResponse(
                HttpStatus.OK,
                200,
                "Login Success",
                Optional.ofNullable(user)
        );
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }

}
