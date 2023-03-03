package com.example.database_connect.service;

import com.example.database_connect.entity.Employee;
import com.example.database_connect.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repo;
    public Employee addEmp(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getEmp() {
        return repo.findAll();
    }

    public Employee getEmpId(int id) {
        return repo.findById(id).orElse(null);
    }

    public Employee updateEmp(Employee emp, int id) {
        Employee oldemp = repo.findById(id).orElse(null);
        oldemp.setName(emp.getName());
        oldemp.setSalary(emp.getSalary());
        repo.save(oldemp);
        return oldemp;
    }

    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
