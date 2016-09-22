package com.wenhao.hibernatestudy.controller;

import com.wenhao.hibernatestudy.dao.Employee1;
import com.wenhao.hibernatestudy.domain.Employee;

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
    Employee1 employee1 = new Employee1();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = employee1.get();
        System.out.println(employee);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
