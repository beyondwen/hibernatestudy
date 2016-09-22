package com.wenhao.hibernatestudy.controller;

import com.wenhao.hibernatestudy.dao.Employee1;
import com.wenhao.hibernatestudy.domain.Employee;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
import com.wenhao.hibernatestudy.utils.HibernateUtilsByxml;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtilsByxml.INSTANCE.getSession();
        System.out.println("=======================get============");
        session.get(Employee.class,1);
        System.out.println("=======================get============");
        System.out.println("**************************************");
        System.out.println("=======================load============");
        session.load(Employee.class,1);
        System.out.println("=======================load============");
        //req.setAttribute("employee", "123");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
