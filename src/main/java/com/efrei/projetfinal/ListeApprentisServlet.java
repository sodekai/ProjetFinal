package com.efrei.projetfinal;

import com.efrei.projetfinal.model.ApprentiEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "ListeApprentisServlet", value = "/liste-apprentis")
public class ListeApprentisServlet extends HttpServlet {

    public ListeApprentisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //liste_apprentis = ApprentiSB.getApprentisOfTuteur(...);
        request.getRequestDispatcher("/liste_apprentis.jsp").forward(request, response);
    }

    ;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}