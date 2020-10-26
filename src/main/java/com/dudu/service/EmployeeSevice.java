package com.dudu.service;

import com.dudu.model.Employee;

import java.util.List;

public interface EmployeeSevice {
    List<Employee> selectAll();
    void create(Employee Employee);
    Employee selectOne(Integer EmployeeNo);
    void updateOne(Employee Employee);
    void deleteOne(Integer Employee);
}
