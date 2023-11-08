package com.efrei.projetfinal;

import com.efrei.projetfinal.model.UtilisateurEntity;
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

        // authentification filter
        HttpSession session = httpRequest.getSession();
        UtilisateurEntity user = (UtilisateurEntity) session.getAttribute("user");
        System.out.println("req cors " +req);

        String url = httpRequest.getRequestURI();
        if ((url != null && (url.startsWith(httpRequest.getContextPath() + "/assets/") || url.endsWith("/connexion") || (user != null)))) {
            chain.doFilter(req, res);
        }
        else {
            System.out.println("Page de connexion");
            httpResponse.sendRedirect("connexion");
        }
    }
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void destroy() {
    }
}
