# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Modification compte administrateur

Scenario: Modification du pseudo
  Given L'administrateur est connecté
  When L'administrateur change de pseudo
  Then Le pseudo de l'administrateur est modifié et il est notifié
  
Scenario: Modification du mot de passe
  Given L'administrateur est connecté
  When L'administrateur change de mot de passe
  When Le mot de passe de l'administrateur est modifié et il est notifié
  
Scenario: Modification du pseudo et du mot de passe de l'administrateur
  Given L'administrateur est connecté
  When Le pseudo et le mot de passe de l'administrateur est modifié et il est notifié