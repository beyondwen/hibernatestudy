package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Employee;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
import com.wenhao.hibernatestudy.utils.HibernateUtilsByxml;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Employee1 {


    public void save(Employee employee) {
        Session session = HibernateUtilsByxml.INSTANCE.getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public Employee get() {
        Session session = HibernateUtilsByxml.INSTANCE.getSession();
        Integer integer = 1;
        Employee employee = session.get(Employee.class, integer);
        System.out.println(employee);
        session.close();
        return employee;
    }

    public Employee load() {
        Session session = HibernateUtilsByxml.INSTANCE.getSession();
        Integer integer = 1;
        Employee employee = session.load(Employee.class, integer);
        session.close();
        return employee;
    }
}
