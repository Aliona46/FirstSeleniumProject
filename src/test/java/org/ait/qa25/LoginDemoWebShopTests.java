package org.ait.qa25;

import org.ait.qa25.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginDemoWebShopTests extends TestBaseDemoWebShop {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().fillLoginRegistrationForm(new User().setEmail("sssmith@gmail.com")
                .setPassword("Smith007$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Smith007$") );
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

