package fr.cmfp.tpgestionlistecourse.tpgestionlistecourse;

import fr.cmfp.tpgestionlistecourse.bo.Listes;
import fr.cmfp.tpgestionlistecourse.dal.AjouterSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AjouterSQL ajouterSQL = new AjouterSQL();
        int idListe = Integer.parseInt(request.getParameter("id"));
        ajouterSQL.deleteListe(idListe);
        System.out.println(idListe);
        Listes liste = ajouterSQL.selectListe();
        ArrayList<Listes> tableauListe = ajouterSQL.tableauListe(liste.getNomListe());
        request.setAttribute("liste", tableauListe);
        request.getRequestDispatcher("WEB-INF/index2.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
