package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiEntity;
import com.efrei.projetfinal.model.ApprentiSB;
import com.efrei.projetfinal.model.TuteurSB;
import com.efrei.projetfinal.model.UtilisateurEntity;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArchiverApprentiServlet", value = "/archiver-apprenti")
public class ArchiverApprentiServlet extends HttpServlet {
    @EJB
    private TuteurSB tuteurSB;
    @EJB
    private ApprentiSB apprentiSB;
    private ApprentiEntity apprentiEntity;
    List<ApprentiEntity> apprentiEntityList;

    public ArchiverApprentiServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apprentiId = request.getParameter("apprentiId");
        apprentiEntity = apprentiSB.getApprenti(Integer.parseInt(apprentiId));
        apprentiEntity.setEst_archive(true);
        apprentiSB.modifierApprenti(apprentiEntity);
        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.getAttribute("user");
        apprentiEntityList = tuteurSB.getAllApprentibyTuteurUserId(utilisateurEntity.getIdUtilisateur());
        request.setAttribute("tuteurApprentiList", apprentiEntityList);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }
}