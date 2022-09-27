package com.ufr.croissantshow.modele;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @Column(unique = true, length = 20)
    @Size(min=5, max=20, message = "length should be between 5 and 20")
    @NotBlank(message = "This field is required")
    private String identifiant; // Entre 5 et 20 caractères, doit être unique entre tous les utilisateurs

    @Column(length = 20)
    @Size(min=8, max=24, message = "length should be between 8 and 24")
    @NotBlank(message = "This field is required")
    private String motPasse; // Entre 8 et 24 caractères, au moins une minuscule, une majuscule, un chiffre

    @Column
    @NotBlank(message = "This field is required")
    private String nom;

    @Column
    @NotBlank(message = "This field is required")
    private String prenom;

    @Column
    @Email(message = "Invalid email")
    private String email; // Adresse email valide (format X@Y.Z)

    @Column
    private boolean actif;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private Role role;
}
