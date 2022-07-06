package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.bo.Listes;
import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import fr.cmfp.tpgestionlistecourse.dal.ConnectionProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/pannier")
public class PanierServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AjouterSQL ajouterSQL = new AjouterSQL();
        int idListe = Integer.parseInt(request.getParameter("id"));
        Listes liste = ajouterSQL.selectId(idListe);
        System.out.println(idListe);
        request.setAttribute("nomListe", liste.getNomListe());
        ArrayList<Articles> afficherArticles = ajouterSQL.selectAll(idListe);
        request.setAttribute("article", afficherArticles);


        request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
