package com.wenhao.hibernatestudy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public enum  HibernateUtilsByxml {
    INSTANCE;
    static SessionFactory sessionFactory;

    static {
        Configuration cfg = new Configuration().configure();
        sessionFactory = cfg.buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
