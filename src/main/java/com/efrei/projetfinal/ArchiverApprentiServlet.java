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
    private ApprentiSB apprentiSB;
    public ArchiverApprentiServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apprentiId = request.getParameter("apprentiId");
        apprentiSB.updateArchive(apprentiId);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }
}