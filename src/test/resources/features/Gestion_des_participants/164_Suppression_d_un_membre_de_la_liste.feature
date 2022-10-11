# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Suppression d'un membre de la liste
  
  Scenario: Suppression d'un membre de la liste, avant le mardi 16h
    Given Un membre étant inscrit à un évènement
    And La date actuelle est avant le mardi 16h de la semaine de cet évènement
    When Le membre tente de se désinscrire
    Then Sa désinscription est bien pris en compte, un message l'en informant est affiché
    
  
  Scenario: Suppression d'un membre de la liste, après le mardi 16h
    Given Un membre étant inscrit à un évènement
    And La date actuelle est après le mardi 16h de la semaine de cet évènement
    When Le membre tente de se désinscrire
    Then Sa désinscription est trop tardive, un message l'en informant est affiché 