# Automation priority: null
# Test case importance: VERY_HIGH
# language: en
Feature: Connexion compte membre

Scenario: Connexion avec un compte membre valide
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre son pseudo dans le champ pseudo 
  And L'utilisateur entre son bon mot de passe dans le champ mot de passe
  And L'utilisateur a été accepté par l administrateur
  Then L'utilisateur arrive sur la page interface membre

Scenario: Connexion au compte membre non enregistré dans la base de donnée
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un pseudo dans le champ pseudo
  And L'utilisateur entre un mot de passe dans le champ mot de passe
  And L'utilisateur ne s est pas inscrit
  Then L'utilisateur arrive sur la page de connexion avec un message d erreur
  
Scenario: Connexion au compte membre valide, mais non validé par l'administrateur 
  Given L'utilisateur est sur la page de connexion du site et n est pas connecté
  When L'utilisateur entre un bon pseudo dans le champ pseudo 
  And L'utilisateur entre un bon mot de passe dans le champ mot de passe
  And L'utilisateur n a été accepté par l'administrateur
  Then L'utilisateur arrive sur la page de connexion avec un message d erreur 
  
    
Scenario: Deconnexion à un compte membre valide
  Given L'utilisateur est connecté sur le site
  When L'utilisateur se déconnecte
  Then L'utilisateur arrive sur la page de connexion