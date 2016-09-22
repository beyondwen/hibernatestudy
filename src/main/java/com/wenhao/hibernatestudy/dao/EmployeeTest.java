package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class EmployeeTest {
    public void save() {
        Employee employee = new Employee();
        employee.setName("wenhao");
        employee.setPassword("123456");
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(employee);
        session.close();
        sessionFactory.close();
    }
}
