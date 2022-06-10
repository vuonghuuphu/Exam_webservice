package com.example.exam_webservice.Resource;

import com.example.exam_webservice.Entity.Employee;

import java.util.List;

public interface EmployeeModel {
    Employee save (Employee employee);
    Employee update (Employee employee,int id);
    List<Employee> findall ();
    Employee findbyid (int id);
}
