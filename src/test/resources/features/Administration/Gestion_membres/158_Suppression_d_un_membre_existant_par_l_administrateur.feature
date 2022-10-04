# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Suppression d'un membre existant par l'administrateur
  
Scenario: L'administrateur supprime un membre existant
  When L'administrateur appui sur le bouton supprimer
  Then L'utilisateur concerné est supprimé de la liste
  And Son pseudo est maintenant disponible
  And Si il était chargé d'amener les croissants la prochaine personne doit être recalculée