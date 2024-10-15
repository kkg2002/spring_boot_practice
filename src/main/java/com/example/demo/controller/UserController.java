package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.repository.UserRepository;
import com.example.demo.user.Employee;

// import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserRepository userRepo ;

    // @GetMapping
    // public String showUserPage(Model model) {
    //     model.addAttribute("employees", userRepo.findAll()); // Add all employees to the model
    //     return "index"; // Return the name of the HTML file (without .html)
    // }
    //find all users
    @GetMapping
    public List<Employee> findAllUser(){
        System.out.println("All employees found");
        return userRepo.findAll();
    }

    //find by id
    @GetMapping("/{_id}")
    public String findbyid(@PathVariable String _id){
        Optional<Employee> emp = userRepo.findById(_id);
        if (emp.isPresent()) {
            System.out.println("employee found with id " + _id);
            return "Emp found" ;
        }
        else{
            System.out.println("employee is not found with id " + _id);
            return " emp not founded" ;
        }
    }

    //Create a new employee
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee emp){
        userRepo.save(emp);
        return "Employee Added" ;
    }

    @PutMapping("/{_id}")
    public String UpdateEmployee(@PathVariable String _id ,@RequestBody Employee emp){
        Optional<Employee> employee = userRepo.findById(_id) ;
        // if(!employee.isPresent()) userRepo.save(emp);
        // emplyee.set_id(emp.get_id()) ; we can not set id
        Employee employee1 = employee.get();
        employee1.setAge(emp.getAge());
        employee1.setEmail(emp.getEmail());
        employee1.setName(emp.getName());
        userRepo.save(employee1) ;
        System.out.println("Employee updated with id " +_id);
        return "Employee Updated" ;
    }
    @DeleteMapping("/{_id}")
    public String deleteUser(@PathVariable String _id){
        userRepo.deleteById(_id);
        System.out.println("employee delted with id " + _id);
        return "deltion completed" ;
    }
}