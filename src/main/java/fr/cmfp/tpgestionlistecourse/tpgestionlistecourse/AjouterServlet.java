package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.bo.Listes;
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
        String nomListe = request.getParameter("nom");
        ajouterSQL.insertListe(nomListe);
        request.setAttribute("nom", nomListe);
        request.getRequestDispatcher("WEB-INF/nouvelleliste.jsp").forward(request, response);

    }
}