# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Un membre peut se réinscrire à un Crossant Show auquel il s'était désinscrit
  
  Scenario: Réinscription d'un membre absent, avant le mardi 16h
    Given Un membre étant absent à un évènement
    And La date actuelle est avant le mardi 16h de la semaine de cet évènement
    When Le membre tente de se réinscrire
    Then Sa réinscription est bien prise en compte, un message l'en informant est affiché
    
  
  Scenario: Réinscription d'un membre absent, après le mardi 16h
    Given Un membre étant absent à un évènement
    And La date actuelle est après le mardi 16h de la semaine de cet évènement
    When Le membre tente de se réinscrire
    Then Sa réinscription est trop tardive, un message l'en informant est affiché 