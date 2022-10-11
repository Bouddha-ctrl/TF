# Automation priority: null
# Test case importance: LOW
# language: en
  Feature: Affectation du responsable de l'évènement
    
    Scenario: Affectation Responsable
      Given Une Liste de participant pour un mercredi
      When  La date actuelle est mercredi 00h00
      Then  Un responsable est défini