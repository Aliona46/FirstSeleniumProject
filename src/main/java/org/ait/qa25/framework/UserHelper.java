package org.ait.qa25.framework;

import org.ait.qa25.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-login"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector(".ico-logout"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent2(By.cssSelector(".ico-logout"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }
}
