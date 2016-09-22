package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class ProductTest {
    public void save() {
        Product product = new Product();
        product.setPassword("1234");
        product.setName("wenhao");
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources().buildMetadata(serviceRegistry).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(product);
        session.close();
        sessionFactory.close();
    }
}
