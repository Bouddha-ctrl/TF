# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Interface de connexion des utilisateurs / administrateur

  Scenario: Connexion d'un utilisateur accepté
    Given Un utilisateur veut se connecter
    And L'utilisateur a été validé par l administrateur
    When L'utilisateur entre ses identifiants corrects
    Then L'utilisateur est redirigé vers l interface utilisateur
    
    Scenario: Connexion d'un utilisateur refusé
    Given Un utilisateur veut se connecter
    And L'utilisateur n'a pas été validé par l administrateur
    When L'utilisateur entre ses identifiants corrects
    Then L'utilisateur reçoit un message le prévenant que son compte n est pas actif
    
    Scenario: Connexion de l'administrateur
    Given L'administrateur veut se connecter
    When L'administrateur entre ses identifiants corrects
    Then L'administrateur est redirigé vers une page spéciale unique
    
    Scenario: Connexion avec des identifiants incorrects
    Given Un utilisateur ou l'administrateur veut se connecter
    When L'individu entre des identifiants incorrects
    Then L'individu reçoit un message type Identifiant ou mot de passe incorrect.