package com.sis.controller;

import com.sis.dao.ScoreDAO;
import com.sis.model.Score;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddScoreServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        int subjectId = Integer.parseInt(req.getParameter("subjectId"));
        double score1 = Double.parseDouble(req.getParameter("score1"));
        double score2 = Double.parseDouble(req.getParameter("score2"));

        Score sc = new Score();
        sc.setStudentId(studentId);
        sc.setSubjectId(subjectId);
        sc.setScore1(score1);
        sc.setScore2(score2);

        new ScoreDAO().insert(sc);

        resp.sendRedirect("index.jsp");
    }
}