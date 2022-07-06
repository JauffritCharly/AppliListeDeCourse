package fr.cmfp.tpgestionlistecourse.dal;

import fr.cmfp.tpgestionlistecourse.bo.Articles;
import fr.cmfp.tpgestionlistecourse.bo.Listes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AjouterSQL {


    public void insertListe(String nomListeArticles) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            if (nomListeArticles != null) {

                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO listes(nom) VALUES(?);");
                pstmt.setString(1, nomListeArticles);
                pstmt.executeUpdate();


            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Listes select() {
        Listes liste = new Listes();
        int idListe = 0;
        String nomListe;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt2 = connection.prepareStatement("SELECT id, nom FROM listes order by id desc limit 1 ");
            ResultSet rs = pstmt2.executeQuery();

            while (rs.next()) {
                idListe = rs.getInt("id");
                nomListe = rs.getString("nom");
                liste = new Listes(idListe, nomListe);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }


    public void insertArticle(String nomArticles, int id) {

        try {
            Connection connection = ConnectionProvider.getConnection();

            PreparedStatement pstmt3 = connection.prepareStatement("INSERT INTO articles (nom,id_liste) VALUES(?,?);");
            pstmt3.setString(1, nomArticles);
            pstmt3.setInt(2, id);
            pstmt3.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Articles> selectAll(int idListe) {
        ArrayList<Articles> afficherArticles = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT articles.nom, id_liste FROM articles inner join listes l on articles.id_liste = l.id where l.id = (?);");
            pstmt.setInt(1, idListe);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Articles article = new Articles(
                        rs.getString("nom")
                );
                afficherArticles.add(article);
            }


            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return afficherArticles;
    }

    public Listes selectListe() {
        Listes liste = new Listes();
        int idListe = 0;
        String nomListe;
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt2 = connection.prepareStatement("SELECT id, nom FROM listes");
            ResultSet rs = pstmt2.executeQuery();

            while (rs.next()) {
                idListe = rs.getInt("id");
                nomListe = rs.getString("nom");
                liste = new Listes(idListe, nomListe);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }

    public ArrayList<Listes> tableauListe(String nomListe) {
        ArrayList<Listes> tableauListe = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT id, nom FROM listes");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Listes liste = new Listes(
                        rs.getInt("id"),
                        rs.getString("nom")
                );
                tableauListe.add(liste);
            }


            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return tableauListe;
    }

    public void deleteListe(int id) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "DELETE FROM listes where id = ?"
            );
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePanier() {
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "UPDATE articles SET coche = false"
            );
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Listes selectId(int id) {
        Listes liste = new Listes();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT id , nom FROM listes where id = ?"
            );
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idListe = rs.getInt("id");
                String nomListe = rs.getString("nom");
                liste = new Listes(idListe, nomListe);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return liste;
    }
}



