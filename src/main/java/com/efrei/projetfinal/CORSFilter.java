package com.efrei.projetfinal;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class CORSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) res;
        HttpServletRequest httpRequest = (HttpServletRequest) req;

        // cors filter
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String url = httpRequest.getRequestURI();
        if (url != null && (url.startsWith(httpRequest.getContextPath() + "/assets/") || url.endsWith("/connexion"))) {
            chain.doFilter(req, res);
        }
        else {
            // authentification filter
            HttpSession session = httpRequest.getSession();
            String user = (String) session.getAttribute("user");
            req.setAttribute("user_session", user);
            System.out.println("user_session : "+ req.getAttribute("user_session"));

            if (user == null) {
                System.out.println("L'utilisateur n'est pas authentifié.");
                req.getRequestDispatcher("/connexion.jsp").forward(req, res);
            } else {
                System.out.println("L'utilisateur est authentifié : " + user);
                chain.doFilter(req, res);
            }
        }



    }
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void destroy() {
    }
}
