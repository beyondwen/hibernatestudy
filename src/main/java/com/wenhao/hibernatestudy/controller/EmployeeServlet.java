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
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("wenhao11111");
        Transaction transaction = session.getTransaction();
        transaction.begin();
        Employee employee1 = session.get(Employee.class, 1);
        System.out.println(employee.hashCode());
        System.out.println(employee1.hashCode());
        employee.setName("ceshi22");
        employee.setPassword("122");
        employee1.setName(employee.getName());
        session.update(employee1);
        transaction.commit();
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
