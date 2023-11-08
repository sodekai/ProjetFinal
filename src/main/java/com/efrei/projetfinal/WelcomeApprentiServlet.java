package com.efrei.projetfinal;

import com.efrei.projetfinal.model.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ApprentiInfosViewServlet", value = "/welcome-apprenti")
public class WelcomeApprentiServlet extends HttpServlet {
    @EJB
    private ApprentiSB apprentiSB;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.getAttribute("user");
        if(utilisateurEntity!=null) {
            String role_utilisateur = utilisateurEntity.getRoleUtilisateur();
            int id_utilisateur = utilisateurEntity.getIdUtilisateur();
            ApprentiEntity apprentiEntity = apprentiSB.getApprentiByIdUtilisateur(id_utilisateur);
            List<VisiteEntity> listeVisitesEntity = apprentiSB.getAllApprentiVisites(apprentiEntity.getIdApprenti());
            List<FeedbackApprentiEntity> listeFeedbackApprentiEntity = apprentiSB.getAllApprentiFeedbacks(apprentiEntity.getIdApprenti());
            List<EvaluationEcoleEntity> listeEvaluationsEcoleEntity = apprentiSB.getAllApprentiEvaluationsEcole(apprentiEntity.getIdApprenti());
            request.setAttribute("apprenti", apprentiEntity);
            request.setAttribute("visites", listeVisitesEntity);
            request.setAttribute("feedbacks", listeFeedbackApprentiEntity);
            request.setAttribute("evaluationsEcole", listeEvaluationsEcoleEntity);
            request.getRequestDispatcher("/welcome_apprenti.jsp").forward(request, response);
        } else {

        }
    };
}