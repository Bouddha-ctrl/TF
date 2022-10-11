# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Heure limite d'inscription
  
  Scenario: Désinscription tardive
    Given Un membre inscrit à un évènement de la semaine courante
    And Mardi 16h est dépassé
    When Le membre tente de se désinscrire
    Then Un message d'erreur est affiché, il est considéré comme participant à l'évènement
    
  Scenario: inscription tardive
    Given Un membre non-inscrit à un évènement de la semaine courante
    And Mardi 16h est dépassé
    When Le membre tente de s'inscrire
    Then Un message d'erreur est affiché, il est considéré comme non-participant à l'évènement