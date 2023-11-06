package com.efrei.projetfinal;

import com.efrei.projetfinal.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import java.io.IOException;

public class Tutorat_utils {

    private final ApprentiSB apprentiSB;
    private final TuteurSB tuteurSB;

    public Tutorat_utils() {
        this.tuteurSB = null;
        this.apprentiSB = null;
    }

    public Tutorat_utils(ApprentiSB apprentiSB) {
        this.tuteurSB = null;
        this.apprentiSB = apprentiSB;
        System.out.println(this.apprentiSB);
    }

    public Tutorat_utils(TuteurSB tuteurSB) {
        this.apprentiSB = null;
        this.tuteurSB = tuteurSB;
    }

    public Tutorat_utils(ApprentiSB apprentiSB, TuteurSB tuteurSB) {
        this.apprentiSB = apprentiSB;
        this.tuteurSB = tuteurSB;
    }

    public String get_home_page(String role_utilisateur){
        switch (role_utilisateur) {
            case "apprenti":
                return "/welcome_apprenti.jsp";
            case "tuteur":
                return "/liste_apprentis.jsp";
            case "visiteur":
                return "/hello_user.jsp";
        }
        return "accueil.jsp";
    }

    public void dispatch_to_home_page(UtilisateurEntity utilisateurEntity, HttpServletRequest request, HttpServletResponse response) {
        String role_utilisateur = utilisateurEntity.getRoleUtilisateur();
        String home_page = get_home_page(role_utilisateur);

        System.out.println("role:"+role_utilisateur+" / home_page:"+home_page + " /apprentiSB:" + apprentiSB);

        if(role_utilisateur.equals("apprenti") && apprentiSB != null) {
            int id_utilisateur = utilisateurEntity.getIdUtilisateur();
            System.out.println(id_utilisateur);
            System.out.println("apprenti" + apprentiSB);
            ApprentiEntity apprentiEntity = apprentiSB.getApprentiByIdUtilisateur(id_utilisateur);
            request.setAttribute("apprenti", apprentiEntity);
        } else if(role_utilisateur.equals("tuteur") && tuteurSB != null) {
            // les setAttribute() de Clément
        } else {
            //
        }
        // dispatch
        try {
            request.getRequestDispatcher(home_page).forward(request, response);
        }
        catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
