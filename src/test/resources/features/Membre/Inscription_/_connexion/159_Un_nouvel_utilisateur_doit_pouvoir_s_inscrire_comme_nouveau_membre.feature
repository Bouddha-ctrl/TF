# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Inscription/ enregistrement d'un utilisateur 

Scenario: Inscription avec tous les champs valide 
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un pseudo non utilisé dans le champ pseudo 
  And L'utilisateur entre son prénom
  And l'utilisateur entre son nom
  And L'utilisateur entre un bon mot de passe dans le champ mot de passe
  And L'utilisateur entre une adresse mail valide
  Then L'utilisateur arrive sur la page d accueil en etant connecté 


Scenario: Inscription avec un pseudo présent dans la base de donnée
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un pseudo utilisé dans le champ pseudo 
  And L'utilisateur entre son prénom
  And l'utilisateur entre son nom
  And L'utilisateur entre un bon mot de passe dans le champ mot de passe
  And L'utilisateur entre une adresse mail valide
  Then L'utilisateur arrive sur la page de connexion avec un message 



Scenario: Inscription avec un mauvais mot de passe
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un pseudo non utilisé dans le champ pseudo 
  And L'utilisateur entre son prénom
  And l'utilisateur entre son nom
  And L'utilisateur entre un mauvais mot de passe dans le champ mot de passe
  And L'utilisateur entre une adresse mail valide
  Then L'utilisateur arrive sur la page de connexion avec un message 


Scenario: Inscription avec mail invalide
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un pseudo non utilisé dans le champ pseudo 
  And L'utilisateur entre son prénom
  And l'utilisateur entre son nom
  And L'utilisateur entre un bon mot de passe dans le champ mot de passe
  And L'utilisateur entre une adresse mail invalide
  Then L'utilisateur arrive sur la page de connexion avec un message 

