package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Ajouter")
public class AjouterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AjouterSQL ajouterSQL = new AjouterSQL();
        String nomListeArticles = request.getParameter("nom");
        String nomArticles = request.getParameter("article");
        ajouterSQL.insertListe(nomListeArticles);
        int id = ajouterSQL.select();
        ajouterSQL.insertArticle(nomArticles, id);
        ArrayList<Articles> afficherArticles = ajouterSQL.selectAll(id);
      
        request.setAttribute("nom", nomListeArticles);
        request.setAttribute("article", afficherArticles);
        request.getRequestDispatcher("WEB-INF/nouvelleliste.jsp").forward(request, response);

    }
}