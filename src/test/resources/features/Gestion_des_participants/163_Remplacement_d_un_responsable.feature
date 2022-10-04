# Automation priority: null
# Test case importance: LOW
# language: en
Feature: Remplacement d'un responsable
  
  Scenario: Remplacement valide
    Given un responsable d'évènement se désiste
    And la date actuelle est avant le mardi 23h59 de la semaine de l'évènement
    And personne ne s'est encore porté volontaire pour remplacer le responsable
    When un membre participant à l'évènement se porte responsable
    Then il est responsable de l'évènement
    And Un mail informant les participants du nouveau responsable est envoyé
    
  
  Scenario: Tentative de remplacement après qu'il ait déjà eu lieu
    Given un responsable d'évènement se désiste
    And la date actuelle est avant le mardi 23h59 de la semaine de l'évènement
    And un autre membre s'est déjà porté volontaire pour remplacer le responsable
    When un membre participant à l'évènement se porte responsable
    Then un message est affiché lui annonçant (lui répétant) qu'un remplaçant a déjà été trouvé
    
  Scenario: Tentative de remplacement après la date limite
    Given un responsable d'évènement se désiste
    And la date actuelle est après le mardi 23h59 de la semaine de l'évènement
    When un membre participant à l'évènement se porte responsable
    Then un message est affiché lui annonçant (lui répétant) qu'il est trop tard pour remplacer le responsable
    And l'évènement est annulé