package com.ufr.croissantshow.test.fonctionnel.Administration.Gestion_compte;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Ignore;
import org.openqa.selenium.By;

import static com.ufr.croissantshow.Common.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Connexion_compte_administrateur_81 {
    //only used by 81 goes to connexion page despite semantic
    @Given("L'utilisateur est sur la page principale du site et n'est pas connecté")
    public static void l_utilisateur_est_sur_la_page_principale_du_site_et_n_est_pas_connecté() {
        accessPage("");
        accessPage("login");
        assertNotEquals(driver.findElement(By.cssSelector(".btn-link")).getText(), "PROFIL");
        assertEquals("Connexion",driver.findElement(By.cssSelector(".btn-link")).getText());

        goToConnexion();

    }
    @When("L'utilisateur entre le pseudo {string} dans le champ pseudo")
    public static void l_utilisateur_entre_le_pseudo_dans_le_champ_pseudo(String string) {
        fillUsernameFieldLogin(string);
    }
    @When("L'utilisateur entre le mot de passe {string} dans le champ mot de passe")
    public static void l_utilisateur_entre_le_mot_de_passe_dans_le_champ_mot_de_passe(String string) {
        fillPasswordFieldLogin(string);
    }
    /*
    valide d'abord le login avant de vérifier l'arrivé sur la page d'inscription
     */
    @Then("L'utilisateur arrive sur la page administrateur")
    public static void l_utilisateur_arrive_sur_la_page_administrateur() {
        driver.findElement(By.cssSelector("body > section > div > div > div.col-md-7.col-lg-5.col-xl-5.offset-xl-1.pt-3 > form > button")).click();
        // assertTrue(driver.findElements(By.cssSelector("#navbarButtonsExample3 > ul > li:nth-child(2) > a")).size()!=0);
        String test= driver.getCurrentUrl();
        assertEquals("http://172.20.128.60:8173/admin/home",test);
    }

    //alternative comportment of 81
    @When("L'utilisateur entre le pseudo de l'administrateur dans le champ pseudo")
    public static void l_utilisateur_entre_le_pseudo_de_l_administrateur_dans_le_champ_pseudo() {
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys(ADMIN_LOGIN);
    }
    @When("L'utilisateur entre le mot de passe de l'administrateur dans le champ mot de passe")
    public static void l_utilisateur_entre_le_mot_de_passe_de_l_administrateur_dans_le_champ_mot_de_passe() {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys(ADMIN_PASSWORD);
    }

    @Given("L'utilisateur est sur la page principale du site et n est pas connecté")
    public void lUtilisateurEstSurLaPagePrincipaleDuSiteEtNEstPasConnecté() {

    }
}
