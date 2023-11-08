package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiSB;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "InscriptionServlet", value = "/inscription")
public class InscriptionServlet extends HttpServlet {

    @EJB
    private ApprentiSB apprentiSB;

    public InscriptionServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String action = request.getParameter("action");

        String typeUtilisateur = request.getParameter("typeUtilisateur");

        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String adresseElectronique = request.getParameter("adresseElectronique");
        String telephone = request.getParameter("telephone");

        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motDePasse = request.getParameter("motDePasse");

        //if(typeUtilisateur.equals("apprenti")){
            String anneeAcademique = request.getParameter("anneeAcademique");
            String majeure = request.getParameter("majeure");
            int idEntreprise = Integer.parseInt(request.getParameter("idEntreprise"));
            //Apprenti apprenti = apprentiSB.createApprenti(nom, prenom, adresseElectronique, telephone, nomUtilisateur, motDePasse, anneeAcademique, majeure, idEntreprise);
            //Utilisateur utilisateur = (Utilisateur) apprenti;
        //} else if(typeUtilisateur.equals("tuteur")){

        //}

        HttpSession session = request.getSession();
        //session.setAttribute("utilisateur", utilisateur);
        //request.setAttribute("utilisateur_session", utilisateur);

        request.getRequestDispatcher("/hello_user.jsp").forward(request, response);

        request.getRequestDispatcher("/connexion.jsp").forward(request, response);

    }
}