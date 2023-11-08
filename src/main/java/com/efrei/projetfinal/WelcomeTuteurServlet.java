package com.efrei.projetfinal;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(name = "ViewApprentiListeServlet", value = "/welcome-tuteur")
public class WelcomeTuteurServlet extends HttpServlet {

    public WelcomeTuteurServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //liste_apprentis = ApprentiSB.getApprentisOfTuteur(...);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }

    ;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}