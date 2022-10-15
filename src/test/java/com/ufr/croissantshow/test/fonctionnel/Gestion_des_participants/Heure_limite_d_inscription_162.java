package com.ufr.croissantshow.test.fonctionnel.Gestion_des_participants;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Ignore;

public class Heure_limite_d_inscription_162 {
    @Given("Un membre inscrit à un évènement de la semaine courante")
    public void unMembreInscritÀUnÉvènementDeLaSemaineCourante() {
    }

    @And("Mardi {int}h est dépassé")
    public void mardiHEstDépassé(int arg0) {
    }

    @When("Le membre tente de se désinscrire")
    public void leMembreTenteDeSeDésinscrire() {
    }

    @Then("Un message d{string}évènement")
    public void unMessageDErreurEstAffichéIlEstConsidéréCommeParticipantÀLÉvènement() {
    }

    @Given("Un membre non-inscrit à un évènement de la semaine courante")
    public void unMembreNonInscritÀUnÉvènementDeLaSemaineCourante() {
    }

    @When("Le membre tente de s'inscrire")
    public void leMembreTenteDeSInscrire() {
    }
}
