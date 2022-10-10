# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Désistement du responsable
  
  Scenario: Désistement du responsable
    Given Un évènement avec un responsable
    When  le responsable se désiste
    Then  l'évènement n'a plus de reponsable