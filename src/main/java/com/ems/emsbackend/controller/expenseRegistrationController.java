package com.ems.emsbackend.controller;

import com.ems.emsbackend.exception.UserNotFoundException;
import com.ems.emsbackend.model.expenseRegistration;
import com.ems.emsbackend.repository.expenseRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class expenseRegistrationController {

    @Autowired
    private expenseRegistrationRepository expenseRegistrationRepository;

    @PostMapping("/expense-register")
    expenseRegistration newUser(@RequestBody expenseRegistration newExpenseRegistration) {
        return expenseRegistrationRepository.save(newExpenseRegistration);
    }

    @GetMapping("/expense-registers")
    List<expenseRegistration> getAllUsers(){
        return expenseRegistrationRepository.findAll();
    }

    @GetMapping("/expense-register/{id}")
    expenseRegistration getUserById(@PathVariable Long id){
        return expenseRegistrationRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/expense-register/{id}")
    expenseRegistration updateUser(@RequestBody expenseRegistration newExpenseRegistration, @PathVariable Long id){
        return expenseRegistrationRepository.findById(id)
                .map(expenseRegistration ->{
                    expenseRegistration.setDept_name(newExpenseRegistration.getDept_name());
                    expenseRegistration.setDivision(newExpenseRegistration.getDivision());
                    expenseRegistration.setAccount(newExpenseRegistration.getAccount());
                    expenseRegistration.setSummary(newExpenseRegistration.getSummary());
                    expenseRegistration.setPayment_status(newExpenseRegistration.getPayment_status());
                    expenseRegistration.setArrival_station(newExpenseRegistration.getArrival_station());
                    expenseRegistration.setGetting_off_station(newExpenseRegistration.getGetting_off_station());
                    expenseRegistration.setAmount(newExpenseRegistration.getAmount());
                    expenseRegistration.setNote(newExpenseRegistration.getNote());
                    return expenseRegistrationRepository.save(expenseRegistration);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/expense-register/{id}")
    String deleteUser(@PathVariable Long id){
        if(!expenseRegistrationRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        expenseRegistrationRepository.deleteById(id);
        return "expenseRegistration with id "+id+" successfully deleted.";
    }
}
