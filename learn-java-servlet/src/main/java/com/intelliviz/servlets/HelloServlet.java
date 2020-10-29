package com.intelliviz.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        out.println("<HTML><HEAD><TITLE>Hello World</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<H1>Hello, World!!!!</H1>");
        out.println("</BODY>");
        out.println("</HTML></HEAD>");
        out.close();
    }
}
