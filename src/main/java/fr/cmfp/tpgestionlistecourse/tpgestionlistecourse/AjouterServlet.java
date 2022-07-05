package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

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
        ajouterSQL.insertListe(nomListeArticles, nomArticles);
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }
}
