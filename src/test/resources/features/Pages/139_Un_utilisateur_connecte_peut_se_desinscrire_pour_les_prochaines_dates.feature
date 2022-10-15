# Automation priority: null
# Test case importance: HIGH
# language: en
Feature: Un utilisateur connecté peut se désinscrire pour les prochaines dates
  
  Scenario: Désinscription date passée
    Given l'utilisateur sélectionne une édition passée
    When l'utilisateur clique sur le bouton de désinscription
    Then un message d'erreur s affiche 
    
  Scenario: Désinscription date trop proche
    Given l'utilisateur tente de se désinscrire après mardi à 16h pour le Croissant Show du lendemain
    When l'utilisateur clique sur le bouton de désinscription
    Then un message d'erreur s affiche 
    
  Scenario: Désinscription date future
    Given l'utilisateur sélectionne une édition future (dans plus de 2 jours) du Croissant Show
    When l'utilisateur clique sur le bouton de désinscription
    Then l'utilisateur est retiré des inscrits à cette date
    
  Scenario: Réinscription à une date future
    Given l'utilisateur sélectionne une édition future (dans plus de 2 jours) à laquelle il n est pas inscrit
    When le créateur clique sur le bouton d'inscription
    Then l'utilisateur est ajouté aux inscrits de cette date
  
Feature: Un utilisateur connecté peut se proposer responsable du prochain Croissant Show.
  
  Scenario: Responsable pas inscrit
    Given l'utilisateur tente de se proposer responsable du prochain Croissant Show, auquel il n'est pas inscrit
    When l'utilisateur clique sur le bouton devenir responsable
    Then un message d'erreur demande à l'utilisateur de s'inscrire à cette date
    
  Scenario: Responsable du prochain Croissant Show
    Given l'utilisateur est inscrit au prochain Croissant Show
    When l'utilisateur clique sur le bouton devenir responsable
    Then l'utilisateur devient responsable du prochain Croissant Show
  