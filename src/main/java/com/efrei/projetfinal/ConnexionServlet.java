package com.efrei.projetfinal;

import java.io.*;

import com.efrei.projetfinal.model.*;
import jakarta.ejb.EJB;
import jakarta.ejb.EJBException;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "ConnexionServlet", value = "/connexion")
public class ConnexionServlet extends HttpServlet {

    @EJB
    private UtilisateurSB utilisateurSB;
    @EJB
    private ApprentiSB apprentiSB;

    private Tutorat_utils tutorat_utils;

    public ConnexionServlet() {
        super();
    }

    public void init() throws ServletException {
        tutorat_utils = new Tutorat_utils(apprentiSB);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get connexion");
        HttpSession session = request.getSession();
        UtilisateurEntity utilisateurEntity = (UtilisateurEntity) session.getAttribute("user");
        if(utilisateurEntity==null){
            System.out.println("L'utilisateur n'est pas authentifié / req connexion : " +request);
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        } else {
            System.out.println("L'utilisateur:"+utilisateurEntity);
            tutorat_utils.dispatch_to_home_page(utilisateurEntity, request, response);
        }
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        System.out.println("post connexion");
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
            System.out.println("Utilisateur connecté : "+utilisateurEntity+ "/req: "+ request);
            tutorat_utils.dispatch_to_home_page(utilisateurEntity, request, response);
        } else {
            request.getRequestDispatcher("connexion.jsp").forward(request, response);
        }

    }
}