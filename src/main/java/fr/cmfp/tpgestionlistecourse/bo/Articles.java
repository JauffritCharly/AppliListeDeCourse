package fr.cmfp.tpgestionlistecourse.bo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Articles {
    private String nomArticles;
    private int idListe;
    private boolean coche;


}
