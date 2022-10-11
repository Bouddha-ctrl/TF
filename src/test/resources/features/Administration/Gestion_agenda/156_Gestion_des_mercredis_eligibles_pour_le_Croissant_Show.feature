# Automation priority: null
# Test case importance: MEDIUM
# language: en
Feature: Gestion des mercredis éligibles pour le Croissant Show
  
  Scenario: L'administrateur marque les mercredis non-valides pour l'évenement
    Given L'administrateur est connecté
    When l'utilisateur choisit un jour dans la liste de mercredis annuels
    Then Ce mercredi n'est plus un jour valide pour tenir un Croissant Show