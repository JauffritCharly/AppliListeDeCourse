package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.bo.Listes;
import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Ajouterarticle")
public class AjouterArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/nouvelleliste.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AjouterSQL ajouterSQL = new AjouterSQL();
        String nomArticle = request.getParameter("article");
        Listes liste = ajouterSQL.select();
        ajouterSQL.insertArticle(nomArticle, liste.getId());
        request.setAttribute("nom", liste.getNomListe());
        ArrayList<Articles> afficherArticles = ajouterSQL.selectAll(liste.getId());
        request.setAttribute("article", afficherArticles);
        request.getRequestDispatcher("WEB-INF/nouvelleliste.jsp").forward(request, response);

    }
}