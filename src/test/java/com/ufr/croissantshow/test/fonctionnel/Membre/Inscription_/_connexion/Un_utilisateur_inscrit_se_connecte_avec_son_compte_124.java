package com.ufr.croissantshow.test.fonctionnel.Membre.Inscription_._connexion;

import com.ufr.croissantshow.Common;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static com.ufr.croissantshow.Common.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Un_utilisateur_inscrit_se_connecte_avec_son_compte_124 {


    @Before
    public void setUp() {

        // Local
        /*
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(false);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        */
        // Jenkins
        driver = new HtmlUnitDriver(false);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("L'utilisateur est sur la page de connexion du site et n est pas connecté")
    public void lUtilisateurEstSurLaPageDeConnexionDuSiteEtNEstPasConnecté() {
    }

    @When("L'utilisateur entre son pseudo dans le champ pseudo")
    public void l_utilisateur_entre_son_pseudo_dans_le_champ_pseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
    }

    @And("L'utilisateur entre son bon mot de passe dans le champ mot de passe")
    public void lUtilisateurEntreSonBonMotDePasseDansLeChampMotDePasse() {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("useruser");
    }

    @And("L'utilisateur a été accepté par l administrateur")
    public void lUtilisateurAÉtéAcceptéParLAdministrateur() {
    }

    @Then("L'utilisateur arrive sur la page interface membre")
    public void lUtilisateurArriveSurLaPageInterfaceMembre() {
    }

    @When("L'utilisateur entre un pseudo dans le champ pseudo")
    public void lUtilisateurEntreUnPseudoDansLeChampPseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("userpasinscrit");
    }

    @And("L'utilisateur entre un mot de passe dans le champ mot de passe")
    public void lUtilisateurEntreUnMotDePasseDansLeChampMotDePasse() {
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("userpasinscrit");
    }

    @And("L'utilisateur ne s est pas inscrit")
    public void lUtilisateurNeSEstPasInscrit() {
    }

    @Then("L'utilisateur arrive sur la page de connexion avec un message d erreur")
    public void lUtilisateurArriveSurLaPageDeConnexionAvecUnMessageDErreur() {
        assertEquals("Nom d'utilisateur ou mot de passe erroné",
                driver.findElement(By.cssSelector("body > section > div > div > div.col-md-7.col-lg-5.col-xl-5.offset-xl-1.pt-3 > form > div.alert.alert-danger > div")).getText());
    }

    @When("L'utilisateur entre un bon pseudo dans le champ pseudo")
    public void lUtilisateurEntreUnBonPseudoDansLeChampPseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
    }

    @And("L'utilisateur entre un bon mot de passe dans le champ mot de passe")
    public void lUtilisateurEntreUnBonMotDePasseDansLeChampMotDePasse() {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("userpasinscrit");
    }

    @And("L{string}a été accepté par l'administrateur")
    public void lUtilisateurNAÉtéAcceptéParLAdministrateur() {
    }

    @Given("L'utilisateur est connecté sur le site")
    public void lUtilisateurEstConnectéSurLeSite() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("useruser");
        driver.findElement(By.cssSelector("body > section > div > div > div.col-md-7.col-lg-5.col-xl-5.offset-xl-1.pt-3 > form > button")).click();

        assertTrue(driver.findElements(By.cssSelector("#navbarButtonsExample2 > div > a:nth-child(2) > button")).size()!=0);
    }

    @When("L'utilisateur se déconnecte")
    public void lUtilisateurSeDéconnecte() {
        driver.findElement(By.cssSelector("#navbarButtonsExample2 > div > a:nth-child(2) > button")).click();
    }

    @Then("L'utilisateur arrive sur la page de connexion")
    public void lUtilisateurArriveSurLaPageDeConnexion() {
        assertTrue(driver.findElements(By.id("form1Example13") ).size()!=0);
    }
}
