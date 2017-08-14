package org.tisha.mvc.servlet;

import org.tisha.mvc.db.StudentDao;
import org.tisha.mvc.model.Student;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * @author Tsikhan Kuprevich
 * @since 8/14/2017
 */
@WebServlet(name = "StudentControllerServlet", urlPatterns = "/StudentControllerServlet/*")
public class StudentControllerServlet extends HttpServlet {

    private StudentDao studentDao;

    @Resource(name = "jdbc/hb_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            studentDao = new StudentDao(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Student> students = studentDao.getStudents();
            request.setAttribute("STUDENTS", students);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

}
