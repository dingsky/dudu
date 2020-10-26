package com.dudu.controller;

import com.dudu.model.Employee;
import com.dudu.service.EmployeeSevice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeSevice employeeSevice;

    @PostMapping("/create")
    public String create(@RequestBody Employee employee) {
        employeeSevice.create(employee);
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Integer employeeNo) {
        employeeSevice.deleteOne(employeeNo);
        return "success";
    }

    @PostMapping("/modify")
    public String modify(@RequestBody Employee employee) {
        employeeSevice.updateOne(employee);
        return "success";
    }

    @GetMapping("/queryList")
    public PageInfo<Employee> queryList(@RequestParam("page") Integer page,@RequestParam("size") Integer size){
        PageHelper.startPage(page,size);
        List<Employee> list;
        list = employeeSevice.selectAll();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }


    @GetMapping("/queryone")
    public Employee queryone(@RequestParam("employeeNo") Integer employeeNo){
        return employeeSevice.selectOne(employeeNo);
    }

}
