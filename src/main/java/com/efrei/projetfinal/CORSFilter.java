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

        if(url != null && url.startsWith(httpRequest.getContextPath() + "/api")){
            System.out.println("API: " +req);
            chain.doFilter(req, res);
        }

        else if(user == null &&
                (url != null &&
                    (!url.endsWith("/connexion") && !url.endsWith("/")
                    && !url.startsWith(httpRequest.getContextPath() + "/api")
                    && !url.startsWith(httpRequest.getContextPath() + "/assets/")
                    )
                )
            ){
            httpRequest.getRequestDispatcher("/connexion.jsp").forward(httpRequest, httpResponse);
        } else {
            chain.doFilter(req, res);
        }

        /*
        System.out.println("startsWith api"+(url != null && url.startsWith(httpRequest.getContextPath() + "/api")));
        if ((url != null && (
                (  url.startsWith(httpRequest.getContextPath() + "/api")
                || url.startsWith(httpRequest.getContextPath() + "/assets/")
                || url.endsWith(".html")
                //|| (url.endsWith("/connexion"))
                //|| (user != null)
                )))) {
            System.out.println("req cors " +req + "ok");
            chain.doFilter(req, res);
        }
        else {
            chain.doFilter(req, res);
            //System.out.println("Page de connexion");
            //
            //httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //httpResponse.getWriter().write("User not authenticated");
        }*/
    }
    @Override
    public void init(FilterConfig filterConfig) {
    }
    @Override
    public void destroy() {
    }
}
