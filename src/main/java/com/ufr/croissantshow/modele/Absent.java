package com.ufr.croissantshow.modele;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Absent {
    private Utilisateur utilisateur;
    private RaisonAbsence raison;
}
