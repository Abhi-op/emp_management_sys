package com.example.emp_management.service;

import com.example.emp_management.entity.Employee;
import com.example.emp_management.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;
     public void addEmp(Employee e){
             repo.save(e);
     }
     public void deleteEmp(Employee e){
               repo.delete(e);
     }
     public List<Employee> getAllEmp(){
         return repo.findAll();
     }
     public void update(Employee e){
              repo.updateEmp(e.getId(),e.getName(),e.getAddress(),e.getEmail(),e.getPhone(),e.getSalary());
              System.out.println(e.getId());
         System.out.println(e.getName());
     }
     public Employee getEmpById(Integer id){
         Optional<Employee> e = repo.findById(id);
         return e.orElse(null);
     }
}
