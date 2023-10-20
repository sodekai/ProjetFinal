package com.efrei.projetfinal;

public class Tutorat_utils {
    public static String get_home_page(String role_utilisateur){
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
}
