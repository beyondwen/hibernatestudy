package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Employee;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Employee1Test {

    Employee1 employee1 = new Employee1();

    @Test
    public void get() throws Exception {
        employee1.get();
    }

    @Test
    public void save() throws Exception {
        Employee employee = new Employee();
        employee.setName("fsfsd");
        employee.setPassword("32423");
        employee1.save(employee);
    }

}