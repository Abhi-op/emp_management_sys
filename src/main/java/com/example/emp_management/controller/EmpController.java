package com.example.emp_management.controller;

import com.example.emp_management.entity.Employee;
import com.example.emp_management.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;
       @GetMapping("/")
    public String home(Model m){
           List<Employee> emp = service.getAllEmp();
           m.addAttribute("emp",emp);
           return "index";
       }
       @GetMapping("/addEmp")
       public String addEmpForm(){
           return "add_emp";
       }
       @PostMapping("/register")
       public String empRegister(@ModelAttribute Employee e, HttpSession session){
           System.out.println(e.getEmail());
              service.addEmp(e);
              session.setAttribute("msg","Employee added successfully");
           return "redirect:/";
       }
      @GetMapping("/edit/{id}")
       public String editEmp(@PathVariable Integer id,Model m){
             Employee emp = service.getEmpById(id);
             m.addAttribute("emp",emp);
           return "edit";

       }
       @PostMapping("/update")
       public String update(@ModelAttribute Employee e,HttpSession session){
           System.out.println(e.toString());
           service.update(e);
           session.setAttribute("msg","Employee data updated successFully...");
           return "redirect:/";

       }
       @GetMapping("/delete/{id}")
      public String deleteEmp(@PathVariable Integer id,HttpSession session){
               Employee emp = service.getEmpById(id);
               if(emp!=null){
                   service.deleteEmp(emp);
                   session.setAttribute("msg","Employee Deleted Successfully...");
                   return "redirect:/";
               }
           session.setAttribute("msg","Error while deleting Employee data");
               return "redirect:/";

       }
}
