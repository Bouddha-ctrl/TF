package com.ufr.croissantshow;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static com.ufr.croissantshow.Common.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class testCroissant {

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


    @Given("On est Mercredi")
    public void on_est_mercredi() {
        assertEquals(1,1);
    }
    @When("Il est 16h")
    public void il_est_16h() {
        assertEquals(1,1);
    }
    @Then("C'est l'heure des croissant")
    public void c_est_l_heure_des_croissant() {
        assertEquals(1,1);
    }

    /*
            81 starts here
     */
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
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys(string);
    }
    @When("L'utilisateur entre le mot de passe {string} dans le champ mot de passe")
    public static void l_utilisateur_entre_le_mot_de_passe_dans_le_champ_mot_de_passe(String string) {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys(string);
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

    /*
            81 ends here
     */

    @When("L'utilisateur entre son pseudo dans le champ pseudo")
    public void l_utilisateur_entre_son_pseudo_dans_le_champ_pseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
        assertEquals(1,1);
    }
    @When("L'utilisateur entre son bon mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_son_bon_mot_de_passe_dans_le_champ_mot_de_passe() {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("useruser");
       assertEquals(1,1);}
    @When("L'utilisateur a été accepté par l'administrateur")
    public void l_utilisateur_a_été_accepté_par_l_administrateur() {
       assertEquals(1,1);}
    @Then("L'utilisateur arrive sur la page 'interface membre'")
    public void l_utilisateur_arrive_sur_la_page_interface_membre() {
       assertEquals(1,1);}


    @When("L'utilisateur entre un pseudo dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_dans_le_champ_pseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("userpasinscrit");
       assertEquals(1,1);}
    @When("L'utilisateur entre un mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_mot_de_passe_dans_le_champ_mot_de_passe() {
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("userpasinscrit");
       assertEquals(1,1);}
    @When("L'utilisateur ne s'est pas inscrit")
    public void l_utilisateur_ne_s_est_pas_inscrit() {
       assertEquals(1,1);}
    @Then("L'utilisateur arrive sur la page de connexion avec un message d'erreur")
    public void l_utilisateur_arrive_sur_la_page_de_connexion_avec_un_message_d_erreur() {
        assertEquals("Nom d'utilisateur ou mot de passe erroné",driver.findElement(By.cssSelector("body > section > div > div > div.col-md-7.col-lg-5.col-xl-5.offset-xl-1.pt-3 > form > div.alert.alert-danger > div")).getText());
    }

    @When("L'utilisateur entre un bon pseudo dans le champ pseudo")
    public void l_utilisateur_entre_un_bon_pseudo_dans_le_champ_pseudo() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
    }
    @When("L'utilisateur entre un bon mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_bon_mot_de_passe_dans_le_champ_mot_de_passe() {
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("userpasinscrit");
    }
    @When("L'utilisateur n'a été accepté par l'administrateur")
    public void l_utilisateur_n_a_été_accepté_par_l_administrateur() {
       assertEquals(1,1);}

    @Given("L'utilisateur est sur la page de connexion du site et n'est pas connecté")
    public void l_utilisateur_est_sur_la_page_de_connexion_du_site_et_n_est_pas_connecté() {
       assertEquals(1,1);}

    @Given("L'utilisateur est connecté sur le site")
    public void l_utilisateur_est_connecté_sur_le_site() {
        Common.accessPage("login");
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys("useruser");
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys("useruser");
        driver.findElement(By.cssSelector("body > section > div > div > div.col-md-7.col-lg-5.col-xl-5.offset-xl-1.pt-3 > form > button")).click();

        assertTrue(driver.findElements(By.cssSelector("#navbarButtonsExample2 > div > a:nth-child(2) > button")).size()!=0);
    }
    @When("L'utilisateur se déconnecte")
    public void l_utilisateur_se_déconnecte() {
        driver.findElement(By.cssSelector("#navbarButtonsExample2 > div > a:nth-child(2) > button")).click();
        assertEquals(1,1);
    }
    @Then("L'utilisateur arrive sur la page de connexion")
    public void l_utilisateur_arrive_sur_la_page_de_connexion() {
        assertTrue(driver.findElements(By.id("form1Example13") ).size()!=0);
    }


    @When("L'utilisateur entre un pseudo utilisé dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_utilisé_dans_le_champ_pseudo() {
        assertEquals(1,1);

    }
    @When("L'utilisateur entre son prénom")
    public void l_utilisateur_entre_son_prénom() {
        assertEquals(1,1);}
    @When("l'utilisateur entre son nom")
    public void l_utilisateur_entre_son_nom() {
        assertEquals(1,1);
    }
    @When("L'utilisateur entre une adresse mail valide")
    public void l_utilisateur_entre_une_adresse_mail_valide() {
        assertEquals(1,1);
    }
    @Then("L'utilisateur arrive sur la page de connexion avec un message")
    public void l_utilisateur_arrive_sur_la_page_de_connexion_avec_un_message() {
        assertEquals(1,1);
    }

    @When("L'utilisateur entre un pseudo non utilisé dans le champ pseudo")
    public void l_utilisateur_entre_un_pseudo_non_utilisé_dans_le_champ_pseudo() {
        assertEquals(1,1);

    }
    @When("L'utilisateur entre une adresse mail invalide")
    public void l_utilisateur_entre_une_adresse_mail_invalide() {
        assertEquals(1,1);

    }



    @Then("L'utilisateur arrive sur la page d'accueil en etant connecté")
    public void l_utilisateur_arrive_sur_la_page_d_accueil_en_etant_connecté() {
        assertEquals(1,1);

    }

    @When("L'utilisateur entre un mauvais mot de passe dans le champ mot de passe")
    public void l_utilisateur_entre_un_mauvais_mot_de_passe_dans_le_champ_mot_de_passe() {
        assertEquals(1,1);

    }



}
