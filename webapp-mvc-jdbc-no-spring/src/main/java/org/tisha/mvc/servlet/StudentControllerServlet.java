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
            String command = request.getParameter("command");

            if (command == null) {
                listStudents(request, response);

            } else {

                switch (command) {
                    case "LIST":
                        listStudents(request, response);
                        break;
                    case "ADD":
                        addStudent(request, response);
                        break;
                    case "LOAD":
                        loadStudent(request, response);
                        break;
                    case "UPDATE":
                        updateStudent(request, response);
                        break;
                    case "DELETE":
                        deleteStudent(request, response);
                        break;
                    default:
                        listStudents(request, response);
                }
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("studentId"));
        studentDao.deleteStudentById(id);
        listStudents(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = Integer.parseInt(request.getParameter("studentId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Student student = new Student(id, firstName, lastName, email);
        studentDao.updateStudent(student);
        listStudents(request, response);
    }

    private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String studentId = request.getParameter("studentId");
        Student student = studentDao.getStudent(studentId);
        request.setAttribute("STUDENT", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student.jsp");
        dispatcher.forward(request, response);
    }

    private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Student student = new Student(firstName, lastName, email);
        studentDao.addStudent(student);
        listStudents(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Student> students = studentDao.getStudents();
        request.setAttribute("STUDENTS", students);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
        dispatcher.forward(request, response);
    }

}
