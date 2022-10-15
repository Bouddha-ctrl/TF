package com.ufr.croissantshow.test.fonctionnel.Administration;

import com.ufr.croissantshow.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Ignore;

import com.ufr.croissantshow.testCroissant;

public class GestionCompte {

    // used by 107, 151 and 156
    @Given("L'administrateur est connecté")
    public void l_administrateur_est_connecté() {

        testCroissant.l_utilisateur_est_sur_la_page_principale_du_site_et_n_est_pas_connecté();
        testCroissant.l_utilisateur_entre_le_pseudo_de_l_administrateur_dans_le_champ_pseudo();
        testCroissant.l_utilisateur_entre_le_mot_de_passe_de_l_administrateur_dans_le_champ_mot_de_passe();
        testCroissant.l_utilisateur_arrive_sur_la_page_administrateur();

    }
    @Ignore
    @When("L'administrateur change de pseudo")
    public void l_administrateur_change_de_pseudo() {
    }
    @Ignore
    @Then("Le pseudo de l'administrateur est modifié et il est notifié")
    public void le_pseudo_de_l_administrateur_est_modifié_et_il_est_notifié() {
    }

    @When("L'administrateur change de mot de passe")
    public void l_administrateur_change_de_mot_de_passe() {
        Common.goToProfile();
        Common.modifyPassword("adminadmin");
    }
    @Ignore
    @When("Le mot de passe de l'administrateur est modifié et il est notifié")
    public void le_mot_de_passe_de_l_administrateur_est_modifié_et_il_est_notifié() {

    }
    @Ignore
    @When("Le pseudo et le mot de passe de l'administrateur est modifié et il est notifié")
    public void le_pseudo_et_le_mot_de_passe_de_l_administrateur_est_modifié_et_il_est_notifié() {

    }
}
