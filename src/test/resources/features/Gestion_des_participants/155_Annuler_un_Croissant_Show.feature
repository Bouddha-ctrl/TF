# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Annulation d'un évènement sans responable
  
  Scenario: Annuler un évènement sans responable
    Given Désistement d'un responsable sans remplacement
    When La date actuelle est mercredi 00h00
    Then Evènement annulé