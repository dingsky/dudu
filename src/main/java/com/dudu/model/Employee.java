package com.dudu.model;

import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private Integer employeeNo;

    private String employeeName;

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }
}
