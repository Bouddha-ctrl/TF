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
}
