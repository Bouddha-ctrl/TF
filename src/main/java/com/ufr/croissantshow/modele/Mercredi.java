package com.ufr.croissantshow.modele;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mercredi {
    private Date date;
    private boolean mercrediAnnule; // Si l'admin l'a annulé (jour férié ect) ou si il n'y a pas de responsable
    private List<Utilisateur> presents;
    private List<Absent> absents;
    private Utilisateur responsable;
}
