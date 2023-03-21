package com.example.database_connect.controller;

import com.example.database_connect.entity.Employee;
import com.example.database_connect.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService service;
    @PostMapping("/insert")
    public Employee insertEmployee(@RequestBody Employee emp){
        return service.addEmp(emp);
    }

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return service.getEmp();
    }

    @GetMapping("/getEmp/{id}")
    public Employee getEmployee(@PathVariable int id){
        return service.getEmpId(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee emp,@PathVariable int id){
        return service.updateEmp(emp,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        service.deleteEmp(id);
    }

    @PutMapping("update/hike")
    public List<Employee> hike(){
        return service.hike();
    }
}
