package com.ufr.croissantshow.test.fonctionnel.Administration.Gestion_agenda;

import com.ufr.croissantshow.Common;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Ignore;

import static com.ufr.croissantshow.test.fonctionnel.Administration.Gestion_compte.Connexion_compte_administrateur_81.*;

public class Gestion_des_mercredis_eligibles_156 {

    // used by 107, 151 and 156
    @Given("L'administrateur est connecté")
    public void l_administrateur_est_connecté() {

        l_utilisateur_est_sur_la_page_principale_du_site_et_n_est_pas_connecté();
        l_utilisateur_entre_le_pseudo_de_l_administrateur_dans_le_champ_pseudo();
        l_utilisateur_entre_le_mot_de_passe_de_l_administrateur_dans_le_champ_mot_de_passe();
        l_utilisateur_arrive_sur_la_page_administrateur();

    }

    @Ignore
    @When("l'utilisateur choisit un jour dans la liste de mercredis annuels")
    public void l_utilisateur_choisit_un_jour_dans_la_liste_de_mercredis_annuels() {

    }
    @Ignore
    @Then("Ce mercredi n'est plus un jour valide pour tenir un Croissant Show")
    public void ce_mercredi_n_est_plus_un_jour_valide_pour_tenir_un_croissant_show() {

    }
}
