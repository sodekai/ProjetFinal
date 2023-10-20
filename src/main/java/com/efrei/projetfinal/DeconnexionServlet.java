package com.efrei.projetfinal;

import com.efrei.projetfinal.model.UtilisateurSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "DeconnexionServlet", value = "/deconnexion")
public class DeconnexionServlet  extends HttpServlet {

    @EJB
    private UtilisateurSB utilisateurSB;

    public DeconnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/connexion.jsp").forward(request, response);
    }
}
