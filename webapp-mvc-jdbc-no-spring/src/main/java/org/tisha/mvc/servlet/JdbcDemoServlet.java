package org.tisha.mvc.servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author Tsikhan Kuprevich
 * @since 8/11/2017
 */
@WebServlet(name = "JdbcDemoServlet", urlPatterns = "/JdbcDemoServlet/*")
public class JdbcDemoServlet extends HttpServlet {

    //same resource name as in META-INF/context.xml
    @Resource(name = "jdbc/hb_student_tracker")
    private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();
            String sql = "select * from customer";
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                out.println(email + "<br/>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
