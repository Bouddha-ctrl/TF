package com.ufr.croissantshow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        assertNotEquals(driver.findElement(By.cssSelector(".btn-link")).getText(), "PROFIL");
        assertEquals("Connexion",driver.findElement(By.cssSelector(".btn-link")).getText());
        driver.findElement(By.cssSelector(".btn-link")).click();
    }

    public static void goToProfile(){
        assertEquals(driver.findElement(By.cssSelector(".btn-link")).getText(), "PROFIL");
        assertNotEquals("Connexion",driver.findElement(By.cssSelector(".btn-link")).getText());
        driver.findElement(By.cssSelector(".btn-link")).click();

    }

}
