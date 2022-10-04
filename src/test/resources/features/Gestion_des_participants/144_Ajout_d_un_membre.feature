# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Ajout d'un membre à la liste des participants
  
  Scenario: Ajout d'un membre avant la date butoire
    Given  L'administrateur accepte un nouveau membre avant mardi à 16h
    Then Le nouveau membre est ajouté comme participant à tous les Croissant' Show.
    
   Scenario: Ajout d'un membre après la date butoire
    Given  L'administrateur accepte un nouveau membre après mardi à 16h
    Then Le nouveau membre est ajouté comme participant à toutes les éditions de Croissant' Show sauf le prochain dont les inscriptions sont figées 