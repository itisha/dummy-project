package org.tisha.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Tsikhan Kuprevich
 * @since 8/10/2017
 */
@WebServlet(name = "StudentServlet", urlPatterns = "/StudentServlet/*")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><head><title>The student is confirmed</title></head><body>");
        out.println("<b>The student is confirmed:</b>");
        out.println("<br/><br/>");
        out.println("First Name: " + request.getParameter("firstName"));
        out.println("<br/><br/>");
        out.println("Last Name: " + request.getParameter("lastName"));

        out.println("</body></html>");

    }
}
