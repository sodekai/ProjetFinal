package com.efrei.projetfinal;
import com.efrei.projetfinal.model.ApprentiSB;
import com.efrei.projetfinal.model.UtilisateurEntity;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "TuteurProfileServlet", value="/tuteur-profile")
public class TuteurProfileServlet extends HttpServlet {
    public TuteurProfileServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/tuteur-profile.jsp").forward(request, response);
    }
}