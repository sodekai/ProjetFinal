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

@WebServlet(name = "IndexServlet", value="/")
public class IndexServlet extends HttpServlet {
    @EJB
    private ApprentiSB apprentiSB;
    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.getAttribute("user");
        if(utilisateurEntity != null){
            String role_utilisateur = utilisateurEntity.getRoleUtilisateur();
            System.out.println("Utilisateur connecté : "+utilisateurEntity+ "/req: "+ request);
            Tutorat_utils.to_home_page(role_utilisateur, response);
        } else {
            response.sendRedirect("connexion");
        }
    }
}