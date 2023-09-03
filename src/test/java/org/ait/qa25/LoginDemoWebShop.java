package org.ait.qa25;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginDemoWebShop extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!isLoginLinkPresent()) {
            clickOnLogOutButton();
        }
        clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        fillLoginRegistrationForm("sssmith@gmail.com", "Smith007$");
        click(By.cssSelector(".login-button"));
        Assert.assertTrue(isElementPresent2(By.cssSelector(".ico-logout")));
    }
}

