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
@WebServlet(name = "ModifyEntrepriseServlet", urlPatterns = {"/modify-entreprise/*"})
public class ModifyEntrepriseServlet extends HttpServlet {
    @EJB
    private EntrepriseSB entrepriseSB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or incorrect id");
            return;
        }
        String idStr = pathInfo.substring(1);
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
            return;
        }

        EntrepriseEntity entreprise = entrepriseSB.getEntrepriseById(id);
        if (entreprise == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entreprise not found");
            return;
        }

        request.setAttribute("entreprise", entreprise);
        request.getRequestDispatcher("/modify_entreprise.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing entreprise ID");
            return;
        }
        String idStr = pathInfo.substring(1);
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid entreprise ID format");
            return;
        }

        // Retrieve the enterprise entity from the database
        EntrepriseEntity entreprise = entrepriseSB.getEntrepriseById(id);
        if (entreprise == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Entreprise not found");
            return;
        }

        // Update the enterprise entity with form data
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String informationsUtiles = request.getParameter("informationsUtiles");

        entreprise.setRaisonSociale(raisonSociale);
        entreprise.setAdresse(adresse);
        entreprise.setInformationsUtiles(informationsUtiles);

        // Call the service bean to update the enterprise
        try {
            entrepriseSB.updateEntreprise(entreprise);
            response.sendRedirect(request.getContextPath() + "/modify-entreprise/" + id + "?updateStatus=success");
        } catch (Exception e) {
            // Log the exception, and maybe forward to an error page
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/modify-entreprise/" + id + "?updateStatus=failure");
        }
    }


}

