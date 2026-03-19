package com.sis.dao;

import com.sis.model.Score;
import com.sis.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ScoreDAO {

    public void insert(Score sc) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO student_score_t(student_id, subject_id, score1, score2) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sc.getStudentId());
            ps.setInt(2, sc.getSubjectId());
            ps.setDouble(3, sc.getScore1());
            ps.setDouble(4, sc.getScore2());

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}