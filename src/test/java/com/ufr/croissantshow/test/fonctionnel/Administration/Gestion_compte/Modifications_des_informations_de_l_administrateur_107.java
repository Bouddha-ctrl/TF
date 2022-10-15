package com.ufr.croissantshow.test.fonctionnel.Administration.Gestion_compte;

import com.ufr.croissantshow.Common;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Ignore;

public class Modifications_des_informations_de_l_administrateur_107 {
    @When("L'administrateur change de mot de passe")
    public void l_administrateur_change_de_mot_de_passe() {
        Common.goToProfile();
        Common.modifyPassword("adminadmin");
    }


    @When("L'administrateur change de pseudo")
    public void lAdministrateurChangeDePseudo() {
    }

    @Then("Le pseudo de l'administrateur est modifié et il est notifié")
    public void lePseudoDeLAdministrateurEstModifiéEtIlEstNotifié() {
    }

    @When("Le mot de passe de l'administrateur est modifié et il est notifié")
    public void leMotDePasseDeLAdministrateurEstModifiéEtIlEstNotifié() {
    }

    @When("Le pseudo et le mot de passe de l'administrateur est modifié et il est notifié")
    public void lePseudoEtLeMotDePasseDeLAdministrateurEstModifiéEtIlEstNotifié() {
    }
}
