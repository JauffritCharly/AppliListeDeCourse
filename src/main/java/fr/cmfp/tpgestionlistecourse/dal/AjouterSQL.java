package fr.cmfp.tpgestionlistecourse.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjouterSQL {
    public void insertListe(String nomListe) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            if (nomListe == null) {
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO listes(nom) VALUES(?);");
                pstmt.setString(1, nomListe);
                pstmt.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
