package com.ems.emsbackend.controller;

import com.ems.emsbackend.exception.UserNotFoundException;
import com.ems.emsbackend.model.expenseList;
import com.ems.emsbackend.repository.expenseListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class expenseListController {

    @Autowired
    private expenseListRepository expenseListRepository;

    @PostMapping("/expense-list")
    expenseList newEmployee(@RequestBody expenseList newExpenseList){
        return expenseListRepository.save(newExpenseList);
    }

    @GetMapping("/expense-lists")
    List<expenseList> getAllEmployee(){
        return expenseListRepository.findAll();
    }

    @GetMapping("/expense-list/{id}")
    expenseList getEmployeeById(@PathVariable Long id){
        return expenseListRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/expense-list/{id}")
    expenseList updateEmployee(@RequestBody expenseList newExpenseList, @PathVariable Long id){
        return expenseListRepository.findById(id)
                .map(user->{
                    user.setEmployee_no(newExpenseList.getEmployee_no());
                    user.setFull_name(newExpenseList.getFull_name());
                    user.setApplication_date_from(newExpenseList.getApplication_date_from());
                    user.setApplication_date_to(newExpenseList.getApplication_date_to());
                    user.setApproval_month_from(newExpenseList.getApproval_month_from());
                    user.setApproval_month_to(newExpenseList.getApproval_month_to());
                    user.setPayment_date_from(newExpenseList.getPayment_date_from());
                    user.setPayment_date_to(newExpenseList.getPayment_date_to());
                    user.setApproval_status(newExpenseList.getApproval_status());
                    return expenseListRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/expense-list/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!expenseListRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        expenseListRepository.deleteById(id);
        return "expenseRegistration with id "+id+" successfully deleted.";
    }
}
