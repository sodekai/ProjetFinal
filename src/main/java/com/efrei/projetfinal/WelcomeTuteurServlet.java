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

@WebServlet(name = "ViewApprentiListeServlet", value = "/welcome-tuteur")
public class WelcomeTuteurServlet extends HttpServlet {
    @EJB
    private TuteurSB tuteurSB;
    @EJB
    private ApprentiSB apprentiSB;
    List<ApprentiEntity> apprentiEntityList;
    public WelcomeTuteurServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get connexion");
        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.getAttribute("user");
        apprentiEntityList = tuteurSB.getAllApprentibyTuteurUserId(utilisateurEntity.getIdUtilisateur());
        request.setAttribute("tuteurApprentiList", apprentiEntityList);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }

    ;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apprentiId = request.getParameter("apprentiId");
        apprentiSB.updateArchive(apprentiId);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }
}