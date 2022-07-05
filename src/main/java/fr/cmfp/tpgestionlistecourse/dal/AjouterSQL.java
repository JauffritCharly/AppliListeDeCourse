package fr.cmfp.tpgestionlistecourse.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjouterSQL {
    public void insertListe(String nomListeArticles, String nomArticles) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            if (nomListeArticles == null) {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO listes(nom) VALUES(?);");
                pstmt.setString(1, nomListeArticles);
                pstmt.executeUpdate();

                PreparedStatement pstmt2 = connection.prepareStatement("SELECT id FROM listes");
                ResultSet rs = pstmt2.executeQuery();
                int idListe = 0;
                while (rs.next()) {
                    idListe = rs.getInt("id");
                }


                PreparedStatement pstmt3 = connection.prepareStatement("INSERT INTO articles (nom,id_liste) VALUES(?,?);");
                pstmt3.setString(1, nomArticles);
                pstmt3.setInt(2, idListe);
                pstmt3.executeUpdate();

            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
