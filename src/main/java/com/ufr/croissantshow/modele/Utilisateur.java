package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    @Column(length = 20,unique = true)
    @NotBlank(message = "This field is required")
    private String identifiant; // Entre 5 et 20 caractères, doit être unique entre tous les utilisateurs

    @Column(length = 20)
    @NotBlank(message = "This field is required")
    private String motPasse; // Entre 8 et 24 caractères, au moins une minuscule, une majuscule, un chiffre

    @Column
    @Email(message = "Invalide email")
    private String email; // Adresse email valide (format X@Y.Z)

    @Column
    private boolean enAttenteDeValidation;

    @Column
    private boolean estAdmin;
}
