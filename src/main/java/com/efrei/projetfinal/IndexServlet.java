package com.efrei.projetfinal;
import com.efrei.projetfinal.model.ApprentiEntity;
import com.efrei.projetfinal.model.ApprentiSB;
import com.efrei.projetfinal.model.UtilisateurEntity;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "IndexServlet", value="/")
public class IndexServlet extends HttpServlet {
    private Tutorat_utils tutorat_utils;
    @EJB
    private ApprentiSB apprentiSB;
    public IndexServlet() {
        super();
    }

    public void init() throws ServletException {
        tutorat_utils = new Tutorat_utils(apprentiSB);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UtilisateurEntity user = (UtilisateurEntity) session.getAttribute("user");
        if(user != null){
            tutorat_utils.dispatch_to_home_page(user, request, response);
        } else {
            //request.getRequestDispatcher("/accueil.jsp").forward(request, response);
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }

        //request.getRequestDispatcher("/accueil.jsp").forward(request, response);
        /*HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        String requestURI = request.getRequestURI();
*/
        //String[] subRequestURI = requestURI.substring(1).split("/");
        //session.setAttribute("doItOnce", "False");

        /*System.out.println("requete : "+requestURI);
        request.setAttribute("user_session", user);
        System.out.println("user_session : "+ request.getAttribute("user_session"));

        if (user == null) {
            request.getRequestDispatcher("/connexion.jsp").forward(request, response);
        }*/

        /*else if (session.getAttribute("doItonce") == "False"){
            session.setAttribute("doItOnce", "True");
            System.out.println("redirect URI: "+ subRequestURI[0]+'/'+subRequestURI[1]);
            request.getRequestDispatcher(subRequestURI[0]+'/'+subRequestURI[1]).forward(request, response);
        }*/
    }
}