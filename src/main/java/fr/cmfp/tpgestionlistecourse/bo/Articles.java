package fr.cmfp.tpgestionlistecourse.bo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Articles {
    private int id;
    private String nom;
    private int idListe;
    private boolean coche;




}
