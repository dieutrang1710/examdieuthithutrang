package com.sis.controller;

import com.sis.dao.StudentDAO;
import com.sis.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String address = req.getParameter("address");

        Student s = new Student(code, name, address);
        new StudentDAO().insert(s);

        resp.sendRedirect("index.jsp");
    }
}