package com.ufr.croissantshow.test.fonctionnel.Gestion_des_participants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Ignore;

public class Suppression_d_un_membre_de_la_liste_164 {
    @Given("Un membre étant inscrit à un évènement")
    public void unMembreÉtantInscritÀUnÉvènement() {
    }

    @And("La date actuelle est avant le mardi {int}h de la semaine de cet évènement")
    public void laDateActuelleEstAvantLeMardiHDeLaSemaineDeCetÉvènement(int arg0) {
    }

    @Then("Sa désinscription est bien pris en compte, un message l'en informant est affiché")
    public void saDésinscriptionEstBienPrisEnCompteUnMessageLEnInformantEstAffiché() {
    }

    @And("La date actuelle est après le mardi {int}h de la semaine de cet évènement")
    public void laDateActuelleEstAprèsLeMardiHDeLaSemaineDeCetÉvènement(int arg0) {
    }

    @Then("Sa désinscription est trop tardive, un message l'en informant est affiché")
    public void saDésinscriptionEstTropTardiveUnMessageLEnInformantEstAffiché() {
    }
}
