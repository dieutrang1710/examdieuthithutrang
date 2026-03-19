package com.sis.controller;

import com.sis.util.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Map<String, Object>> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT s.student_code, s.full_name, sub.subject_name, sc.score1, sc.score2, sub.credit " +
                    "FROM student_score_t sc " +
                    "JOIN student_t s ON sc.student_id = s.student_id " +
                    "JOIN subject_t sub ON sc.subject_id = sub.subject_id";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Map<String, Object> m = new HashMap<>();

                double s1 = rs.getDouble("score1");
                double s2 = rs.getDouble("score2");
                double avg = 0.3 * s1 + 0.7 * s2;

                String grade;
                if (avg >= 8) grade = "A";
                else if (avg >= 6) grade = "B";
                else if (avg >= 4) grade = "D";
                else grade = "F";

                m.put("code", rs.getString("student_code"));
                m.put("name", rs.getString("full_name"));
                m.put("subject", rs.getString("subject_name"));
                m.put("score1", s1);
                m.put("score2", s2);
                m.put("credit", rs.getInt("credit"));
                m.put("grade", grade);

                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}