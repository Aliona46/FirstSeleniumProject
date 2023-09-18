package org.ait.qa25.framework;

import org.ait.qa25.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

public class UserHelper extends HelperBase {
    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));
    public UserHelper(WebDriver driver) {
        super(driver);
    }
    public void clickOnRegistrationButton () {
        click(By.cssSelector("[name=register-button]"));
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
        click(By.cssSelector("input#gender-male"));
        type(By.cssSelector("#FirstName"), user.getFirstName());
        type(By.cssSelector("#LastName"), user.getLastName());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getPassword());
    }

    public void fillLoginRegistrationFormForScreencast(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        pause(1000);
        type(By.cssSelector("#Password"), user.getPassword());
        pause(2000);
    }
    public void fillLoginRegistrationFormShortForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        pause(1000);
        type(By.cssSelector("#Password"), user.getPassword());
        pause(2000);
    }

    public boolean isLogOutButtonPresent() {
        return isElementPresent2(By.cssSelector("a.ico-logout"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

}
