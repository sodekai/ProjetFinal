package com.efrei.projetfinal;

import java.io.*;
import java.util.Objects;

import com.efrei.projetfinal.model.ApprentiSB;
import com.efrei.projetfinal.model.PersonneSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {


    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motDePasse = request.getParameter("motDePasse");

        HttpSession session = request.getSession();

        if(nomUtilisateur.equals("Sophie") && motDePasse.equals("root")) {
            String user = nomUtilisateur;
            session.setAttribute("user", user);
            request.setAttribute("user_session", user);
            request.getRequestDispatcher("/hello_user.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/connexion.jsp").forward(request, response);

    }
}