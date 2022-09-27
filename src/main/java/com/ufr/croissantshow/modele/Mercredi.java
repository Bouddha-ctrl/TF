package com.ufr.croissantshow.modele;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Mercredi {
    @Id
    @Column
    private Date date;

    @Column
    private boolean mercrediAnnule; // Si l'admin l'a annulé (jour férié ect) ou si il n'y a pas de responsable

    @ManyToMany
    @JoinColumn(name="present_utilisateur_id")
    private List<Utilisateur> presents;

    @ManyToMany
    @JoinColumn(name="absent_id")
    private List<Absent> absents;

    @ManyToOne
    @JoinColumn(name="responsable_utilisateur_id")
    private Utilisateur responsable;
}
