package org.ait.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationDemoWebShopTests extends TestBaseDemoWebShop {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        //if(!isElementPresent(By.xpath("//*[@class='ico-register']"))) {
           // driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        //}
        //click on Login link - a:nth-child(4) - css
        app.getUser().click(By.xpath("//*[@class='ico-register']"));
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        fillRegistrationForm("John", "Smith", "ssmith@gmail.com", "Smith007$");


        clickOnRegistrationButton();
        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        Assert.assertTrue(app.getUser().isElementPresent2(By.cssSelector(".register-continue-button")));
    }

    public void clickOnRegistrationButton() {
        app.getUser().click(By.cssSelector("[name=register-button]"));
    }

    public void fillRegistrationForm(String firstName, String lastName, String email, String password) {
        app.getUser().click(By.cssSelector("#gender-male"));

        app.getUser().click(By.cssSelector("#FirstName"));
        app.driver.findElement(By.cssSelector("#FirstName")).clear();
        app.driver.findElement(By.cssSelector("#FirstName")).sendKeys(firstName);

        app.getUser().click(By.cssSelector("#LastName"));
        app.driver.findElement(By.cssSelector("#LastName")).clear();
        app.driver.findElement(By.cssSelector("#LastName")).sendKeys(lastName);

        app.getUser().click(By.cssSelector("#Email"));
        app.driver.findElement(By.cssSelector("#Email")).clear();
        app.driver.findElement(By.cssSelector("#Email")).sendKeys(email);

        app.getUser().click(By.cssSelector("#Password"));
        app.driver.findElement(By.cssSelector("#Password")).clear();
        app.driver.findElement(By.cssSelector("#Password")).sendKeys(password);

        app.getUser().click(By.cssSelector("#ConfirmPassword"));
        app.driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        app.driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys(password);
    }
}
