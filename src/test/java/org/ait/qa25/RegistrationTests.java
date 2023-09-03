package org.ait.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        //precondition: user should be logged out
        //if(!isElementPresent(By.xpath("//*[@class='ico-register']"))) {
           // driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click();
        //}
        //click on Login link - a:nth-child(4) - css
        driver.findElement(By.xpath("//*[@class='ico-register']")).click();
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        driver.findElement(By.cssSelector("#gender-male")).click();

        driver.findElement(By.cssSelector("#FirstName")).click();
        driver.findElement(By.cssSelector("#FirstName")).clear();
        driver.findElement(By.cssSelector("#FirstName")).sendKeys("John");

        driver.findElement(By.cssSelector("#LastName")).click();
        driver.findElement(By.cssSelector("#LastName")).clear();
        driver.findElement(By.cssSelector("#LastName")).sendKeys("Smith");

        driver.findElement(By.cssSelector("#Email")).click();
        driver.findElement(By.cssSelector("#Email")).clear();
        driver.findElement(By.cssSelector("#Email")).sendKeys("sssmith@gmail.com");

        driver.findElement(By.cssSelector("#Password")).click();
        driver.findElement(By.cssSelector("#Password")).clear();
        driver.findElement(By.cssSelector("#Password")).sendKeys("Smith007$");

        driver.findElement(By.cssSelector("#ConfirmPassword")).click();
        driver.findElement(By.cssSelector("#ConfirmPassword")).clear();
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("Smith007$");


        //click on Registration button - //button[text()='Registration'] - xpath
        driver.findElement(By.cssSelector("[name=register-button]")).click();
        //assert Sign out button displayed - //button[contains(.,'Sign Out')] - xpath
        Assert.assertTrue(isElementPresent2(By.cssSelector(".register-continue-button")));
    }
}
