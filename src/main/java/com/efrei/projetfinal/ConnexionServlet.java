package com.efrei.projetfinal;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "connexion", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/hello_user.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String nom = request.getParameter("nom_utilisateur");
        String prenom = request.getParameter("mot_de_passe");

        HttpSession session = request.getSession();



        session.setAttribute("nom_utilisateur", nom);
        session.setAttribute("mot_de_passe", prenom);

        this.getServletContext().getRequestDispatcher("/WEB-INF/hello_user.jsp").forward(request, response);
    }
}