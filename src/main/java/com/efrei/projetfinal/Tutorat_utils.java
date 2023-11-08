package com.efrei.projetfinal;

import com.efrei.projetfinal.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletContext;

import java.io.IOException;
import java.util.List;

public class Tutorat_utils {

    public static String get_home_page(String role_utilisateur){
        switch (role_utilisateur) {
            case "apprenti":
                return "welcome-apprenti";
            case "tuteur":
                return "welcome-tuteur";
            default:
                return "connexion";
        }
    }

    public static void to_home_page(String role_utilisateur, HttpServletResponse response) throws IOException {
        String home_page = get_home_page(role_utilisateur);
        response.sendRedirect(home_page);
    }
}
