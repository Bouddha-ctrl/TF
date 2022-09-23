package com.ufr.croissantshow.modele;

public class Utilisateur {
    private int id;
    private String identifiant; // Entre 5 et 20 caractères, doit être unique entre tous les utilisateurs
    private String motPasse; // Entre 8 et 24 caractères, au moins une minuscule, une majuscule, un chiffre
    private String email; // Adresse email valide (format X@Y.Z)
    private boolean enAttenteDeValidation;
    private boolean estAdmin;
}
