package com.efrei.projetfinal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "IndexServlet", value="/", loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String requestURI = request.getRequestURI();
        String[] subRequestURI = requestURI.substring(1).split("/");
        session.setAttribute("doItOnce", "False");
        System.out.println("requete : "+requestURI);
        request.setAttribute("user_session", user);
        if (user == null) {
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }
        else if (session.getAttribute("doItonce") == "False"){
            System.out.println("ok");
            session.setAttribute("doItOnce", "True");
            //String redirectURI = Arrays.toString(subRequestURI);
            System.out.println("redirect URI: "+ subRequestURI[0]+'/'+subRequestURI[1]);
            request.getRequestDispatcher(subRequestURI[0]+'/'+subRequestURI[1]).forward(request, response);
            //request.getRequestDispatcher("/hello_user.jsp").forward(request, response);
        }
    }
}