package com.efrei.projetfinal;

import java.io.*;
import java.util.Objects;

import com.efrei.projetfinal.model.*;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    @EJB
    private UtilisateurSB utilisateurSB;
    @EJB
    private ApprentiSB apprentiSB;

    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motDePasse = request.getParameter("motDePasse");

        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity;
        try {
            utilisateurEntity = utilisateurSB.getUtilisateurByIdentifiants(nomUtilisateur, motDePasse);
        }
        catch(EJBException e){
            request.setAttribute("message_error", "utilisateur non trouvé");
            utilisateurEntity = null;
        }

        if(utilisateurEntity != null) {
            session.setAttribute("user", utilisateurEntity);
            String home_page = Tutorat_utils.get_home_page(utilisateurEntity.getRoleUtilisateur());
            request.getRequestDispatcher(home_page).forward(request, response);
        }
        request.getRequestDispatcher("/connexion.jsp").forward(request, response);


    }
}