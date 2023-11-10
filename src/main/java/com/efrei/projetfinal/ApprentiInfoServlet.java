package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiEntity;
import com.efrei.projetfinal.model.ApprentiSB;
import com.efrei.projetfinal.model.EntrepriseEntity;
import com.efrei.projetfinal.model.EntrepriseSB;
import com.efrei.projetfinal.model.MaitreApprentissageEntity;
import com.efrei.projetfinal.model.MaitreApprentissageSB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ejb.EJB;
import jakarta.ws.rs.PathParam;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApprentiInfoServlet", value = "/apprenti-infos/*")
public class ApprentiInfoServlet extends HttpServlet {

    @EJB
    private ApprentiSB apprentiSB;

    @EJB
    private EntrepriseSB entrepriseSB;

    @EJB
    private MaitreApprentissageSB maitreApprentissageSB;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HELLLLOOO");
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or incorrect id");
            return;
        }
        String idStr = pathInfo.substring(1); // gets the "id" part of the URL
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
            return;
        }
        ApprentiEntity a = apprentiSB.getApprenti(id);
        if (a == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Apprenti not found");
            return;
        }

        // Fetch all Entreprise entities
        List<EntrepriseEntity> entreprises = entrepriseSB.getAllEntreprises();
        List<MaitreApprentissageEntity> maitresApprentissage = maitreApprentissageSB.getAllMaitres();

        // Set the other request attributes
        request.setAttribute("maitresApprentissage", maitresApprentissage);
        request.setAttribute("apprenti", a);
        request.setAttribute("entreprises", entreprises);

        request.getRequestDispatcher("/apprenti_infos.jsp").forward(request, response);
        request.setAttribute("addEntrepriseURL", request.getContextPath() + "/add-entreprise");
        request.setAttribute("modifyEntrepriseURL", request.getContextPath() + "/modify-entreprise");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or incorrect id");
            return;
        }

        String idStr = pathInfo.substring(1); // gets the "id" part of the URL
        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid id format");
            return;
        }

        ApprentiEntity apprenti = apprentiSB.getApprenti(id);
        if (apprenti == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Apprenti not found");
            return;
        }

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String anneeAcademique = request.getParameter("anneeAcademique");
        String majeure = request.getParameter("majeure");
        String entreprise = request.getParameter("entreprise");
        String maitreApprentissage = request.getParameter("maitreApprentissage");

        // Update the apprenti object
        apprenti.getUtilisateur().getPersonne().setNom(nom);
        apprenti.getUtilisateur().getPersonne().setPrenom(prenom);
        apprenti.setAnneeAcademique(anneeAcademique);
        apprenti.setMajeure(majeure);

        String entrepriseIdStr = request.getParameter("entreprise");
        String maitreApprentissageIdStr = request.getParameter("maitreApprentissage");
        System.out.println("entrepriseIdStr: " + entrepriseIdStr);
        System.out.println("maitreApprentissageIdStr: " + maitreApprentissageIdStr);

        try {
            int entrepriseId = Integer.parseInt(entrepriseIdStr);
            int maitreApprentissageId = Integer.parseInt(maitreApprentissageIdStr);

            EntrepriseEntity selectedEntreprise = entrepriseSB.getEntrepriseById(entrepriseId);
            MaitreApprentissageEntity selectedMaitreApprentissage = maitreApprentissageSB.getMaitreById(maitreApprentissageId);

            apprenti.setEntreprise(selectedEntreprise);
            apprenti.setIdMaitreApprentissage(selectedMaitreApprentissage);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid entreprise or maitreApprentissage id format");
            return;
        }

        try {
            apprentiSB.modifierApprenti(apprenti);
            response.sendRedirect(request.getContextPath() + "/apprenti-infos/" + id + "?updateStatus=success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/apprenti-infos/" + id + "?updateStatus=failure");
        }

    }
}
