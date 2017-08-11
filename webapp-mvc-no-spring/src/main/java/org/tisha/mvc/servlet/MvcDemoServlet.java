package org.tisha.mvc.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Tsikhan Kuprevich
 * @since 8/11/2017
 */
@WebServlet(name = "MvcDemoServlet", urlPatterns = "/MvcDemoServlet/*")
public class MvcDemoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //read data from db:
        String[] students = {"Susan", "Ani", "Mohamed", "Trupti"};
        request.setAttribute("students", students);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/students.jsp");
        requestDispatcher.forward(request, response);
    }
}
