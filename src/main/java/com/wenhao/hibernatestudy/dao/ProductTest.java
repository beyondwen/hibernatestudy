package com.wenhao.hibernatestudy.dao;

import com.wenhao.hibernatestudy.domain.Product;
import com.wenhao.hibernatestudy.domain.Product1;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class ProductTest {
    public void save(Product product) {
        HibernateUtils<Product> hibernateUtils = new HibernateUtils<Product>();
        Session session = hibernateUtils.getSession(Product.class);
        Transaction transaction = session.getTransaction();
        transaction.begin();
        //StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //SessionFactory sessionFactory = new MetadataSources().buildMetadata(serviceRegistry).buildSessionFactory();
        //Session session = sessionFactory.openSession();
        session.save(product);
        transaction.commit();
        session.close();
        //sessionFactory.close();
    }
}
