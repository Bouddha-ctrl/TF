# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Connexion compte administrateur

Scenario: Connexion au compte administrateur par défaut
  Given L'utilisateur est sur la page principale du site et n est pas connecté
  When L'utilisateur entre le pseudo "adminadmin" dans le champ pseudo
  And L'utilisateur entre le mot de passe "adminadmin" dans le champ mot de passe
  Then L'utilisateur arrive sur la page administrateur
  
Scenario: Connexion au compte administrateur modifier
  Given L'utilisateur est sur la page principale du site et n est pas connecté
  When L'utilisateur entre le pseudo de l'administrateur dans le champ pseudo
  And L'utilisateur entre le mot de passe de l'administrateur dans le champ mot de passe
  Then L'utilisateur arrive sur la page administrateur
