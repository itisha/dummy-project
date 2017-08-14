package org.tisha.mvc.db;

import org.tisha.mvc.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tsikhan Kuprevich
 * @since 8/14/2017
 */
public class StudentDao {

    private DataSource dataSource;

    public StudentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Student> getStudents() throws Exception {
        List<Student> students = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "SELECT * FROM customer ORDER BY last_name";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                );
                students.add(student);
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return students;
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = dataSource.getConnection();
            String sql = "INSERT INTO customer " +
                    "(first_name, last_name, email) " +
                    "VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getEmail());

            statement.execute();
        } finally {
            close(connection, statement, null);
        }
    }
}
