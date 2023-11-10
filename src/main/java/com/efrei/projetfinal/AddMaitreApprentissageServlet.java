package com.efrei.projetfinal;

import com.efrei.projetfinal.model.EntrepriseEntity;
import com.efrei.projetfinal.model.EntrepriseSB;
import com.efrei.projetfinal.model.MaitreApprentissageEntity;
import com.efrei.projetfinal.model.MaitreApprentissageSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddMaitreApprentissageServlet", value = "/add-maitre-apprentissage")
public class AddMaitreApprentissageServlet extends HttpServlet {

    @EJB
    private MaitreApprentissageSB maitreApprentissageSB;

    @EJB
    private EntrepriseSB entrepriseSB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EntrepriseEntity> entreprises = entrepriseSB.getAllEntreprises();
        request.setAttribute("entreprises", entreprises);
        request.getRequestDispatcher("/add_maitre_apprentissage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresseElectronique = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String poste = request.getParameter("poste");
        int idEntreprise = Integer.parseInt(request.getParameter("entreprise"));

        MaitreApprentissageEntity maitre = maitreApprentissageSB.createMaitreApprentissage(nom, prenom, adresseElectronique, telephone,"", poste, idEntreprise);
        try {

            response.sendRedirect(request.getContextPath() + "/add-maitre-apprentissage?status=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/add-maitre-apprentissage?status=failure");
        }
    }
}
