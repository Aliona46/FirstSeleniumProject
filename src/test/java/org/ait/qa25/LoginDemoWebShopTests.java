package org.ait.qa25;

import org.ait.qa25.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

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
    public void loginPositiveTestWithScreencast() throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();

        app.getUser().fillLoginRegistrationFormForScreencast(new User()
                .setEmail("sssmith@gmail.com")
                .setPassword("Smith007$"));

        app.getUser().clickOnLoginButton();
        app.getUser().pause(2000);
        app.getUser().stopRecording();

    }

    @Test
    public void loginNegativeWithoutEmailTest() {
        app.getUser().fillLoginRegistrationForm(new User().setPassword("Smith007$") );
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}

