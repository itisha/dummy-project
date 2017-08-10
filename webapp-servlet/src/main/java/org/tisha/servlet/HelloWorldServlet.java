package org.tisha.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

/**
 * @author Tsikhan Kuprevich
 * @since 8/10/2017
 */
@WebServlet(name = "HelloWorldServlet", urlPatterns = {"/HelloWorldServlet/*", "/servlet/*"})
public class HelloWorldServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Hello World Servlet<h2>");
        out.println("<hr/>");
        out.println("Current date is: " + Instant.now());
        out.println("<body/><html/>");
    }
}
