package com.example.database_connect.service;

import com.example.database_connect.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public Employee addEmp(Employee emp);
    public List<Employee> getEmp();
    public Employee getEmpId(int id);
    public Employee updateEmp(Employee emp,int id);
    public void deleteEmp(int id);
    public List<Employee> hike();
}
