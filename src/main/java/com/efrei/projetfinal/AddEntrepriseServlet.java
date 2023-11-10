package com.efrei.projetfinal;

import com.efrei.projetfinal.model.EntrepriseEntity;
import com.efrei.projetfinal.model.EntrepriseSB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;

import java.io.IOException;

@WebServlet(name = "AddEntrepriseServlet", value = "/add-entreprise")
public class AddEntrepriseServlet extends HttpServlet {

    @EJB
    private EntrepriseSB entrepriseSB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add_entreprise.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String informationsUtiles = request.getParameter("informationsUtiles");


        try {
            entrepriseSB.createEntreprise(raisonSociale, adresse, informationsUtiles);
            response.sendRedirect(request.getRequestURI()+"?updateStatus=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getRequestURI()+"?updateStatus=failure");
        }


    }

}
