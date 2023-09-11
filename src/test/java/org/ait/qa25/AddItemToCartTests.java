package org.ait.qa25;

import org.ait.qa25.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBaseDemoWebShop {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User().setEmail("sssmith@gmail.com")
                .setPassword("Smith007$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogOutButtonPresent());
    }

    @Test
    public void addItemToCartPositiveTest() {
        app.getItem().clickOnItemIcon();
        app.getItem().clickOnAddToCartButton();
        app.getItem().clickOnCartLink();
        Assert.assertTrue(app.getItem().isItemAdded());

    }

    @AfterMethod
    public void postCondition() {
        app.getItem().removeItem();
    }


}
