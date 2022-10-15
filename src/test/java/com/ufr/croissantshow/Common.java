package com.ufr.croissantshow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Common {

    public static WebDriver driver;
    public static String dockerServer = "http://172.20.128.60";
    public static String PORT = "8173";

    public static final String ADMIN_LOGIN="adminadmin";
    public static final String ADMIN_PASSWORD="adminadmin";

    public static void initDriver(){
        driver = new HtmlUnitDriver(false);
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void accessPage(String page){
        StringBuilder sb = new StringBuilder();
        if (page.length()>0 && page.charAt(0)!='/')
            sb.append('/');
        sb.append(page);
        driver.get(dockerServer+":"+PORT+sb);
    }

    public static void goToConnexion(){
        assertNotEquals("Profil",driver.findElement(By.cssSelector(".btn-link")).getText());
        assertEquals("Connexion",driver.findElement(By.cssSelector(".btn-link")).getText());
        driver.findElement(By.cssSelector(".btn-link")).click();
    }

    public static void goToProfile(){
        assertEquals("Profil",driver.findElement(By.cssSelector(".btn-link")).getText());
        assertNotEquals("Connexion",driver.findElement(By.cssSelector(".btn-link")).getText());
        driver.findElement(By.cssSelector(".btn-link")).click();
    }

    public static void fillUsernameFieldLogin(String s){
        assertEquals("http://172.20.128.60:8173/login",driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@id='form1Example13']")).sendKeys(s);
    }

    public static void fillPasswordFieldLogin(String s){
        assertEquals("http://172.20.128.60:8173/login",driver.getCurrentUrl());
        driver.findElement(By.xpath("//input[@id='form1Example23']")).sendKeys(s);
    }

    public static void modifyPassword(String s){

        driver.findElement(By.cssSelector("body")).click();
        driver.findElement(By.id("form3Example5")).clear();

        driver.findElement(By.id("form3Example5")).sendKeys(s);
        driver.findElement(By.cssSelector(".btn-block")).click();
        assertEquals(("L'utilisateur est modifié"),driver.findElement(By.cssSelector("strong")).getText());
    }


}
