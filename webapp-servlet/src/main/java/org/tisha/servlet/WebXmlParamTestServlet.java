package org.tisha.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Tsikhan Kuprevich
 * @since 8/11/2017
 */
@WebServlet(name = "WebXmlParamTestServlet", urlPatterns = "/WebXmlParamTestServlet")
public class WebXmlParamTestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        Enumeration<String> parameterNames = context.getInitParameterNames();

        out.println("<h3>Context params are:</h3>");
        out.println("<ul>");
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            out.println("<li>" + name + " : " + context.getInitParameter(name) + "</li>");
        }
        out.println("</ul>");
    }
}
