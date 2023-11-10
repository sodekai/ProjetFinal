package com.efrei.projetfinal;

import com.efrei.projetfinal.model.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ModifyMaitreApprentissageServlet", urlPatterns = {"/modify-maitre-apprentissage/*"})
public class ModifyMaitreApprentissageServlet extends HttpServlet {
    @EJB
    private MaitreApprentissageSB maitreApprentissageSB;

    @EJB
    private EntrepriseSB entrepriseSB;

    int id;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or incorrect id");
            return;
        }
        id = extractId(pathInfo);
        MaitreApprentissageEntity maitre = maitreApprentissageSB.getMaitreById(id);
        if (maitre == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Maitre not found");
            return;
        }

        List<EntrepriseEntity> entreprises = entrepriseSB.getAllEntreprises();
        request.setAttribute("maitre", maitre);
        request.setAttribute("entreprises", entreprises);
        request.getRequestDispatcher("/modify_maitre_apprentissage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaitreApprentissageEntity maitre = maitreApprentissageSB.getMaitreById(id);
        if (maitre == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Maitre not found");
            return;
        }

        updateMaitreFromRequest(maitre, request, id);

        try {
            maitreApprentissageSB.updateMaitre(maitre);
            response.sendRedirect(request.getContextPath() + "/modify-maitre-apprentissage/" + id + "?updateStatus=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/modify-maitre-apprentissage/" + id + "?updateStatus=failure");
        }
    }

    private int extractId(String pathInfo) throws NumberFormatException {
        if (pathInfo == null || pathInfo.equals("/")) {
            throw new IllegalArgumentException("Path info is missing or incorrect");
        }
        String idStr = pathInfo.substring(1);
        return Integer.parseInt(idStr);
    }


    private void updateMaitreFromRequest(MaitreApprentissageEntity maitre, HttpServletRequest request, int id) {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresseElectronique = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String poste = request.getParameter("poste");
        int idEntreprise = Integer.parseInt(request.getParameter("entreprise"));

        maitre.getPersonne().setNom(nom);
        maitre.getPersonne().setPrenom(prenom);
        maitre.getPersonne().setAdresseElectronique(adresseElectronique);
        maitre.getPersonne().setTelephone(telephone);

        maitre.setPoste(poste);
        maitre.setIdMaitreApprentissage(id);
        EntrepriseEntity entreprise = entrepriseSB.getEntrepriseById(idEntreprise);
        maitre.setEntreprise(entreprise);
    }

}
