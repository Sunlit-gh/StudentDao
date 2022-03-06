package daoIMP;

import bean.Student;
import dao.StudentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO {
    // 添加操作
    public void insert(Student s) {
        String sql = "use Students INSERT INTO student (iD, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //针对数据库的具体操作
        try {
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2, s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void update(Student s) {
        String sql = "use Students UPDATE student SET name =? Where iD = ?";
        PreparedStatement pstmt;
        DataBaseConnection conn;
        try {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1, s.getName());
            pstmt.setLong(2, s.getID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void delete(long iD) {
        String sql = "use Students DELETE FROM student WHERE iD = ?";
        PreparedStatement preparedStatement;
        DataBaseConnection connection;
        try {
            connection = new DataBaseConnection();
            preparedStatement = connection.getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, iD);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Student> findAll() {
        Student student;
        String sql = "use Students SELECT * FROM student";
        PreparedStatement pstmt;
        DataBaseConnection conn;
        List<Student> allStudents = new ArrayList<>();
        try
        {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                student = new Student();
                student.setID(rs.getLong(1));
                student.setName(rs.getString(2));
                allStudents.add(student);
            }
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return allStudents;
    }

    public Student findByID(long iD) {
        Student student = null;
        String sql = "use Students SELECT iD, name FROM student Where iD = ? ";
        PreparedStatement pstmt;
        DataBaseConnection conn;
        try
        {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, iD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                student = new Student();
                student.setID(rs.getLong(1));
                student.setName(rs.getString(2));
            }
            rs.close();
            pstmt.close();
            conn.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return student;
    }

}
