package com.wenhao.hibernatestudy.controller;

import com.wenhao.hibernatestudy.dao.Employee1;
import com.wenhao.hibernatestudy.domain.Employee;
import com.wenhao.hibernatestudy.utils.HibernateUtils;
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
    //Employee1 employee1 = new Employee1();
    HibernateUtils<Employee> hibernateUtils = new HibernateUtils<Employee>();
    Session session = hibernateUtils.getSession(Employee.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Integer integer = 1;
        Employee employee = session.get(Employee.class, integer);
        System.out.println(employee);
        employee.setName("ceshi22");
        employee.setPassword("122");
        session.update(employee);
        //employee1.save(employee);
        transaction.commit();
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
