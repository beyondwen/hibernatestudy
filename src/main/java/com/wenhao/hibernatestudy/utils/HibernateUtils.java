package com.wenhao.hibernatestudy.utils;

import com.wenhao.hibernatestudy.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jpamodelgen.xml.jaxb.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class HibernateUtils<T> {
    static Configuration configuration = new Configuration();

    static {
        //定义一个properties
        Properties properties = new Properties();
        //获得properties文件
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties");
        try {
            //加载到内存中
            properties.load(inputStream);
            //通过configuration添加properties文件，获得里面的数据
            configuration = configuration.addProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession(Class<T> classz) {
        //通过加载持久化对象，获得   持久化对象.hbm.xml 文件 并创建SessionFactory
        SessionFactory sessionFactory = configuration.addClass(classz).buildSessionFactory();
        //创建session对象
        Session session = sessionFactory.openSession();
        return session;
    }
}
