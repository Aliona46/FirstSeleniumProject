package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddItemToCart extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!isLoginLinkPresent()) {
            clickOnLogOutButton();
        }
        clickOnLoginLink();

        fillLoginRegistrationForm("sssmith@gmail.com", "Smith007$");
        click(By.cssSelector(".login-button"));
        Assert.assertTrue(isElementPresent2(By.cssSelector(".ico-logout")));
    }

    @Test
    public void addItemToCartPositiveTest() {
        click(By.cssSelector("img[src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
        click(By.cssSelector("#add-to-cart-button-31"));
        click(By.cssSelector("a.ico-cart span.cart-label"));
        Assert.assertTrue(isElementPresent2(By.cssSelector("td.product a.product-name")));

    }
    @AfterMethod
    public void postCondition() {
        click(By.cssSelector("[name=removefromcart]"));
        click(By.cssSelector("[name=updatecart]"));
    }



}
