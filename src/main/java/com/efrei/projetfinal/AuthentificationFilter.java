package com.efrei.projetfinal;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthentificationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession();
        String user = (String) session.getAttribute("user");
        request.setAttribute("user_session", user);
        System.out.println("user_session : "+ request.getAttribute("user_session"));

        if (user == null) {
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }

        chain.doFilter(request, response);
    }

    public void destroy() {
        // Nettoyage du filtre (si nécessaire)
    }
}