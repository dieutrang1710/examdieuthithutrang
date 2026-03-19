package com.sis.dao;

import com.sis.model.Student;
import com.sis.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void insert(Student s) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO student_t(student_code, full_name, address) VALUES (?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getStudentCode());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getAddress());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}