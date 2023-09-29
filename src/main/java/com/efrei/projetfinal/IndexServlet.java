package com.efrei.projetfinal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user_session");
        request.setAttribute("user_session", user);
        if (user == null) {
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/hello_user.jsp").forward(request, response);
        }
    }
}