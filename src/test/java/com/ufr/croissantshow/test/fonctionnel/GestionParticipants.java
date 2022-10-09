package com.ufr.croissantshow.test.fonctionnel;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Ignore;

public class GestionParticipants {
    @Ignore
    @Given("Une Liste de participant pour un mercredi")
    public void une_liste_de_participant_pour_un_mercredi() {

    }
    @Ignore
    @When("La date actuelle est mercredi 00h00")
    public void la_date_actuelle_est_mercredi_00h00() {

    }
    @Ignore
    @Then("Un responsable est défini")
    public void un_responsable_est_défini() {

    }


    @Ignore
    @Given("L'administrateur accepte un nouveau membre avant mardi à 16h")
    public void l_administrateur_accepte_un_nouveau_membre_avant_mardi_à_16h() {

    }
    @Ignore
    @Then("Le nouveau membre est ajouté comme participant à tous les Croissant' Show.")
    public void le_nouveau_membre_est_ajouté_comme_participant_à_tous_les_croissant_show() {

    }


    @Ignore
    @Given("L'administrateur accepte un nouveau membre après mardi à 16h")
    public void l_administrateur_accepte_un_nouveau_membre_après_mardi_à_16h() {

    }
    @Ignore
    @Then("Le nouveau membre est ajouté comme participant à toutes les éditions de Croissant' Show sauf le prochain dont les inscriptions sont figées")
    public void le_nouveau_membre_est_ajouté_comme_participant_à_toutes_les_éditions_de_croissant_show_sauf_le_prochain_dont_les_inscriptions_sont_figées() {

    }


    @Ignore
    @Given("Désistement d'un responsable sans remplacement")
    public void désistement_d_un_responsable_sans_remplacement() {

    }
    @Ignore
    @Then("Evènement annulé")
    public void evènement_annulé() {

    }


    @Ignore
    @Given("Un évènement avec un responsable")
    public void un_évènement_avec_un_responsable() {

    }
    @Ignore
    @When("le responsable se désiste")
    public void le_responsable_se_désiste() {

    }
    @Ignore
    @Then("l'évènement n'a plus de reponsable")
    public void l_évènement_n_a_plus_de_reponsable() {

    }


    @Ignore
    @Given("Un membre inscrit à un évènement de la semaine courante")
    public void un_membre_inscrit_à_un_évènement_de_la_semaine_courante() {

    }
    @Ignore
    @Given("Mardi 16h est dépassé")
    public void mardi_16h_est_dépassé() {

    }
    @Ignore
    @When("Le membre tente de se désinscrire")
    public void le_membre_tente_de_se_désinscrire() {

    }
    @Ignore
    @Then("Un message d'erreur est affiché, il est considéré comme participant à l'évènement")
    public void un_message_d_erreur_est_affiché_il_est_considéré_comme_participant_à_l_évènement() {

    }


    @Ignore
    @Given("Un membre non-inscrit à un évènement de la semaine courante")
    public void un_membre_non_inscrit_à_un_évènement_de_la_semaine_courante() {

    }
    @Ignore
    @When("Le membre tente de s'inscrire")
    public void le_membre_tente_de_s_inscrire() {

    }
    @Ignore
    @Then("Un message d'erreur est affiché, il est considéré comme non-participant à l'évènement")
    public void un_message_d_erreur_est_affiché_il_est_considéré_comme_non_participant_à_l_évènement() {

    }


    @Ignore
    @Given("un responsable d'évènement se désiste")
    public void un_responsable_d_évènement_se_désiste() {

    }
    @Ignore
    @Given("la date actuelle est avant le mardi 23h59 de la semaine de l'évènement")
    public void la_date_actuelle_est_avant_le_mardi_23h59_de_la_semaine_de_l_évènement() {

    }
    @Ignore
    @Given("personne ne s'est encore porté volontaire pour remplacer le responsable")
    public void personne_ne_s_est_encore_porté_volontaire_pour_remplacer_le_responsable() {

    }
    @Ignore
    @When("un membre participant à l'évènement se porte responsable")
    public void un_membre_participant_à_l_évènement_se_porte_responsable() {

    }
    @Ignore
    @Then("il est responsable de l'évènement")
    public void il_est_responsable_de_l_évènement() {

    }
    @Ignore
    @Then("Un mail informant les participants du nouveau responsable est envoyé")
    public void un_mail_informant_les_participants_du_nouveau_responsable_est_envoyé() {

    }


    @Ignore
    @Given("un autre membre s'est déjà porté volontaire pour remplacer le responsable")
    public void un_autre_membre_s_est_déjà_porté_volontaire_pour_remplacer_le_responsable() {

    }
    @Ignore
    @Then("un message est affiché lui annonçant \\(lui répétant) qu'un remplaçant a déjà été trouvé")
    public void un_message_est_affiché_lui_annonçant_lui_répétant_qu_un_remplaçant_a_déjà_été_trouvé() {

    }


    @Ignore
    @Given("la date actuelle est après le mardi 23h59 de la semaine de l'évènement")
    public void la_date_actuelle_est_après_le_mardi_23h59_de_la_semaine_de_l_évènement() {

    }
    @Ignore
    @Then("un message est affiché lui annonçant \\(lui répétant) qu'il est trop tard pour remplacer le responsable")
    public void un_message_est_affiché_lui_annonçant_lui_répétant_qu_il_est_trop_tard_pour_remplacer_le_responsable() {

    }
    @Ignore
    @Then("l'évènement est annulé")
    public void l_évènement_est_annulé() {

    }



    @Ignore
    @Given("Un membre étant inscrit à un évènement")
    public void un_membre_étant_inscrit_à_un_évènement() {

    }
    @Ignore
    @Given("La date actuelle est avant le mardi 16h de la semaine de cet évènement")
    public void la_date_actuelle_est_avant_le_mardi_16h_de_la_semaine_de_cet_évènement() {

    }
    @Ignore
    @Then("Sa désinscription est bien pris en compte, un message l'en informant est affiché")
    public void sa_désinscription_est_bien_pris_en_compte_un_message_l_en_informant_est_affiché() {

    }


    @Ignore
    @Given("La date actuelle est après le mardi 16h de la semaine de cet évènement")
    public void la_date_actuelle_est_après_le_mardi_16h_de_la_semaine_de_cet_évènement() {

    }
    @Ignore
    @Then("Sa désinscription est trop tardive, un message l'en informant est affiché")
    public void sa_désinscription_est_trop_tardive_un_message_l_en_informant_est_affiché() {

    }


    @Ignore
    @Given("Un évènement a lieu mercredi prochain")
    public void un_évènement_a_lieu_mercredi_prochain() {

    }
    @Ignore
    @Then("Parmis les participants, celui qui a le rapport nombre_de_croissants_consommés\\/nombre_de_croissants_payés le plus important est désigné responsable")
    public void parmisLesParticipantsCeluiQuiALeRapportNombre_de_croissants_consommésNombre_de_croissants_payésLePlusImportantEstDésignéResponsable() {
    }

    @Ignore
    @Given("Un membre étant absent à un évènement")
    public void unMembreÉtantAbsentÀUnÉvènement() {
    }

    @Ignore
    @When("Le membre tente de se réinscrire")
    public void leMembreTenteDeSeRéinscrire() {
    }

    @Ignore
    @Then("Sa réinscription est bien prise en compte, un message l'en informant est affiché")
    public void saRéinscriptionEstBienPriseEnCompteUnMessageLEnInformantEstAffiché() {
    }

    @Ignore
    @Then("Sa réinscription est trop tardive, un message l'en informant est affiché")
    public void saRéinscriptionEstTropTardiveUnMessageLEnInformantEstAffiché() {
    }
}
