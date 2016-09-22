package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Employee;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Employee1 {
    public void save(Employee employee) {
        HibernateUtils<Employee> hibernateUtils = new HibernateUtils<Employee>();
        Session session = hibernateUtils.getSession(Employee.class);
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(employee);
        transaction.commit();
        session.close();
    }
}
