package dao;

import util.Connector;
import model.Student;

import java.sql.*;

public class StudentDAO {

    public static void saveStudent(Student student) {
        final  String SAVE_STUDENT = "INSERT INTO Student VALUES(?,?,?,?,?,?)";
        Connection conn = Connector.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SAVE_STUDENT);
            ps.setString(1,student.getId());
            ps.setString(2,student.getName());
            java.sql.Date sqlDate = new java.sql.Date(student.getBirthDay().getTime());
            ps.setDate(3,  sqlDate);
            ps.setString(4,student.getSex());
            ps.setString(5,student.getVillage());
            ps.setString(6,student.getPhoneNumber());
            ps.executeUpdate();
            System.out.println("Lưu vào data base thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Student findStudentById(String id) {
        final String SELECT_BY_ID = "SELECT * FROM Student WHERE id = " + id;
        Connection conn = Connector.getConnection();
        Student student = new Student();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                student.setId(rs.getString("id"));
                student.setBirthDay(rs.getDate("birthDay"));
                student.setSex(rs.getString("sex"));
                student.setName(rs.getString("name"));
                student.setVillage(rs.getString("village"));
                student.setPhoneNumber(rs.getString("phoneNumber"));
                System.out.println(student);
            }
            while (!rs.next()) {
                System.out.println("Sinh viên không tồn tại");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

}
