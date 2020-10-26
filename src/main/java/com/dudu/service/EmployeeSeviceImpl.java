package com.dudu.service;

import com.dudu.dao.mongodb.EmployeeMapper;
import com.dudu.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("EmployeeSevice")
public class EmployeeSeviceImpl implements EmployeeSevice{

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> selectAll() {
        return this.employeeMapper.selectAll();
    }

    @Override
    public void create(Employee employee) {
        this.employeeMapper.insert(employee);
    }

    @Override
    public Employee selectOne(Integer employeeNo) {
        return this.employeeMapper.selectOne(employeeNo);
    }

    @Override
    public void updateOne(Employee employee) {
        this.employeeMapper.update(employee);
    }

    @Override
    public void deleteOne(Integer employeeNo) {
       this.employeeMapper.delete(employeeNo);
    }
}
