package com.ems.emsbackend.controller;

import com.ems.emsbackend.exception.UserNotFoundException;
import com.ems.emsbackend.model.User;
import com.ems.emsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/expense")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/expenses")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/expense/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/expense/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user->{
                    user.setDept_name(newUser.getDept_name());
                    user.setDivision(newUser.getDivision());
                    user.setAccount(newUser.getAccount());
                    user.setSummary(newUser.getSummary());
                    user.setPayment_status(newUser.getPayment_status());
                    user.setArrival_station(newUser.getArrival_station());
                    user.setGetting_off_station(newUser.getGetting_off_station());
                    user.setAmount(newUser.getAmount());
                    user.setNote(newUser.getNote());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/expense/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id "+id+" successfully deleted.";
    }
}
