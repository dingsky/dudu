package com.dudu.dao.mongodb;

import com.dudu.model.Employee;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("employleeDao")
public class EmployeeMapper {
    @Resource
    private MongoTemplate mongoTemplate;

    public void insert(Employee employee) {
        mongoTemplate.insert(employee);
    }

    public void update(Employee employee) {
        mongoTemplate.save(employee);
    }

    public void delete(Integer employeeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeNo").is(employeeId));
        mongoTemplate.remove(query, Employee.class);
    }

    public List<Employee> selectAll() {
       return mongoTemplate.findAll(Employee.class);
    }

    public Employee selectOne(Integer employeeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("employeeNo").is(employeeId));
        return mongoTemplate.findOne(query, Employee.class);
    }
}
