package com.example.database_connect.service;

import com.example.database_connect.entity.Employee;
import com.example.database_connect.repository.EmployeeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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
        if(emp.getName()!=null) oldemp.setName(emp.getName());
        if(emp.getSalary()!= 0.0) oldemp.setSalary(emp.getSalary());
        if(emp.getAge()!=0) oldemp.setAge(emp.getAge());
        repo.save(oldemp);
        return oldemp;
    }

    public void deleteEmp(int id) {
        repo.deleteById(id);
    }

    public List<Employee> hike() {
        List<Employee> emps = repo.findAll();
        Iterator<Employee> I = emps.iterator();
        while(I.hasNext()){
            Employee emp = I.next();
            if(emp.getAge()>=25){
                emp.setSalary((float) (emp.getSalary()*1.25));
            }
            else{
                emp.setSalary((float) (emp.getSalary()*1.1));
            }
        }
        repo.saveAll(emps);
        return emps;
    }
}
