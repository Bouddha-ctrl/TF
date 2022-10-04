# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Gestion des demandes de compte

Scenario: Acceptation d'une demande de compte
  Given L'administrateur est connecté
  When L'administrateur accepte la demande d'un utilisateur
  Then L'utilisateur est ajouté à la liste des utilisateurs et peut désormais se connecter
  
Scenario: Invalidation d'une demande de compte
  Given L'administrateur est connecté
  When L'administrateur refuse la demande d'un utilisateur
  Then L'utilisateur n'est pas créé