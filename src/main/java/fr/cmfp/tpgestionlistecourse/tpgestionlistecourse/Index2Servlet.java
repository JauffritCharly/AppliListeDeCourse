package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.bo.Listes;
import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Index2Servlet")
public class Index2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AjouterSQL ajouterSQl = new AjouterSQL();
        Listes liste = ajouterSQl.selectListe();
        ArrayList<Listes> tableauListe = ajouterSQl.tableauListe(liste.getNomListe());
        request.setAttribute("liste", tableauListe);
        request.getRequestDispatcher("WEB-INF/index2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
