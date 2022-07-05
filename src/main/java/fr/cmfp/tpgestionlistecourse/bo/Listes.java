package fr.cmfp.tpgestionlistecourse.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Listes {
    private int id;
    private String nomListe;


    public Listes() {
        this.nomListe = nomListe;
    }
}
