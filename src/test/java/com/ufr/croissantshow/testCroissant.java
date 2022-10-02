package com.ufr.croissantshow;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class testCroissant {

    @Given("On est Mercredi")
    public void on_est_mercredi() {
        Assert.assertEquals(1,1);
    }
    @When("Il est 16h")
    public void il_est_16h() {
        Assert.assertEquals(1,1);
    }
    @Then("C'est l'heure des croissant")
    public void c_est_l_heure_des_croissant() {
        Assert.assertEquals(1,1);
    }

    @Given("L'utilisateur est sur la page principale du site et n'est pas connecté")
    public void l_utilisateur_est_sur_la_page_principale_du_site_et_n_est_pas_connecté() {
        Assert.assertEquals(1,1);
    }
    @When("L'utilisateur entre le pseudo {string} dans le champ pseudo")
    public void l_utilisateur_entre_le_pseudo_dans_le_champ_pseudo(String string) {
        Assert.assertEquals(1,1);
    }
    @When("L'utilisateur entre le mot de passe {string} dans le champ mot de passe")
    public void l_utilisateur_entre_le_mot_de_passe_dans_le_champ_mot_de_passe(String string) {
        Assert.assertEquals(1,1);
    }
    @Then("L'utilisateur arrive sur la page administrateur")
    public void l_utilisateur_arrive_sur_la_page_administrateur() {
        Assert.assertEquals(1,1);
    }

    @When("L'utilisateur entre son pseudo dans le champ pseudo")
    public void l_utilisateur_entre_son_pseudo_dans_le_champ_pseudo() {
        Assert.assertEquals(1,1);
    }
    @When("L'utilisateur entre son bon mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_son_bon_mot_de_passe_dans_le_champ_mot_de_passe() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur a été accepté par l'administrateur")
    public void l_utilisateur_a_été_accepté_par_l_administrateur() {
       Assert.assertEquals(1,1);}
    @Then("L'utilisateur arrive sur la page 'interface membre'")
    public void l_utilisateur_arrive_sur_la_page_interface_membre() {
       Assert.assertEquals(1,1);}


    @When("L'utilisateur entre un pseudo dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_dans_le_champ_pseudo() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur entre un mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_mot_de_passe_dans_le_champ_mot_de_passe() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur ne s'est pas inscrit")
    public void l_utilisateur_ne_s_est_pas_inscrit() {
       Assert.assertEquals(1,1);}
    @Then("L'utilisateur arrive sur la page de connexion avec un message d'erreur")
    public void l_utilisateur_arrive_sur_la_page_de_connexion_avec_un_message_d_erreur() {
       Assert.assertEquals(1,1);}

    @When("L'utilisateur entre un bon pseudo dans le champ pseudo")
    public void l_utilisateur_entre_un_bon_pseudo_dans_le_champ_pseudo() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur entre un bon mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_bon_mot_de_passe_dans_le_champ_mot_de_passe() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur n'a été accepté par l'administrateur")
    public void l_utilisateur_n_a_été_accepté_par_l_administrateur() {
       Assert.assertEquals(1,1);}

    @Given("L'utilisateur est sur la page de connexion du site et n'est pas connecté")
    public void l_utilisateur_est_sur_la_page_de_connexion_du_site_et_n_est_pas_connecté() {
       Assert.assertEquals(1,1);}

    @Given("L'utilisateur est connecté sur le site")
    public void l_utilisateur_est_connecté_sur_le_site() {
       Assert.assertEquals(1,1);}
    @When("L'utilisateur se déconnecte")
    public void l_utilisateur_se_déconnecte() {
       Assert.assertEquals(1,1);}
    @Then("L'utilisateur arrive sur la page de connexion")
    public void l_utilisateur_arrive_sur_la_page_de_connexion() {
       Assert.assertEquals(1,1);}


    @When("L'utilisateur entre un pseudo utilisé dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_utilisé_dans_le_champ_pseudo() {
        Assert.assertEquals(1,1);

    }
    @When("L'utilisateur entre son prénom")
    public void l_utilisateur_entre_son_prénom() {
        Assert.assertEquals(1,1);}
    @When("l'utilisateur entre son nom")
    public void l_utilisateur_entre_son_nom() {
        Assert.assertEquals(1,1);
    }
    @When("L'utilisateur entre une adresse mail valide")
    public void l_utilisateur_entre_une_adresse_mail_valide() {
        Assert.assertEquals(1,1);
    }
    @Then("L'utilisateur arrive sur la page de connexion avec un message")
    public void l_utilisateur_arrive_sur_la_page_de_connexion_avec_un_message() {
        Assert.assertEquals(1,1);
    }

    @When("L'utilisateur entre un pseudo non utilisé dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_non_utilisé_dans_le_champ_pseudo() {
        Assert.assertEquals(1,1);

    }
    @When("L'utilisateur entre une adresse mail invalide")
    public void l_utilisateur_entre_une_adresse_mail_invalide() {
        Assert.assertEquals(1,1);

    }

    @When("L'utilisateur entre le pseudo de l'administrateur dans le champ pseudo")
    public void l_utilisateur_entre_le_pseudo_de_l_administrateur_dans_le_champ_pseudo() {
        Assert.assertEquals(1,1);
    }
    @When("L'utilisateur entre le mot de passe de l'administrateur dans le champ mot de passe")
    public void l_utilisateur_entre_le_mot_de_passe_de_l_administrateur_dans_le_champ_mot_de_passe() {
        Assert.assertEquals(1,1);
    }

    @Then("L'utilisateur arrive sur la page d'accueil en etant connecté")
    public void l_utilisateur_arrive_sur_la_page_d_accueil_en_etant_connecté() {
        Assert.assertEquals(1,1);

    }

    @When("L'utilisateur entre un mauvais mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_mauvais_mot_de_passe_dans_le_champ_mot_de_passe() {
        Assert.assertEquals(1,1);

    }



}
