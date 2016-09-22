package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Employee;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Employee1 {
    HibernateUtils<Employee> hibernateUtils = new HibernateUtils<Employee>();
    Session session = hibernateUtils.getSession(Employee.class);

    public void save(Employee employee) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(employee);
        transaction.commit();
        //session.close();
    }

    public Employee get() {
        Integer integer = 1;
        Employee employee = session.get(Employee.class, integer);
        return employee;
    }
}
