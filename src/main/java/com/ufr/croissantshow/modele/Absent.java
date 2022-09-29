package com.ufr.croissantshow.modele;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Absent {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name="utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="raison_absence_id")
    private RaisonAbsence raison;
}
