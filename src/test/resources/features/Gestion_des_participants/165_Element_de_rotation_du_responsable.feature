# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Elément de rotation du responsable
  
  Scenario: Choix automatique du nouveau responsable
    Given Un évènement a lieu mercredi prochain
    When La date actuelle est mercredi 00h00
    Then Parmis les participants, celui qui a le rapport nombre_de_croissants_consommés sur nombre_de_croissants_payés le plus important est désigné responsable