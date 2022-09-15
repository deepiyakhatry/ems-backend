package com.ems.emsbackend.controller;

import com.ems.emsbackend.exception.UserNotFoundException;
import com.ems.emsbackend.model.Employee;
import com.ems.emsbackend.model.User;
import com.ems.emsbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    Employee getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }
    @PutMapping("/employee/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){
        return employeeRepository.findById(id)
                .map(user->{
                    user.setEmployee_no(newEmployee.getEmployee_no());
                    user.setFull_name(newEmployee.getFull_name());
                    user.setApplication_date_from(newEmployee.getApplication_date_from());
                    user.setApplication_date_to(newEmployee.getApplication_date_to());
                    user.setApproval_month_from(newEmployee.getApproval_month_from());
                    user.setApproval_month_to(newEmployee.getApproval_month_to());
                    user.setPayment_date_from(newEmployee.getPayment_date_from());
                    user.setPayment_date_to(newEmployee.getPayment_date_to());
                    user.setApproval_status(newEmployee.getApproval_status());
                    return employeeRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    @DeleteMapping("/employee/{id}")
    String deleteEmployee(@PathVariable Long id){
        if(!employeeRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        employeeRepository.deleteById(id);
        return "User with id "+id+" successfully deleted.";
    }
}
