package org.ait.qa25;

import org.ait.qa25.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RegistrationDemoWebShopTests extends TestBaseDemoWebShop {
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }

            app.getUser().click(By.xpath("//a[@href='/register' and @class='ico-register']"));
        }



        @Test
        public void newUserRegistrationPositiveTest () {
            fillRegistrationForm("John1", "Smith", "ssssssssmith@gmail.com", "Smith007$");


            clickOnRegistrationButton();

            Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".register-continue-button")));
        }

        public void clickOnRegistrationButton () {
            app.getUser().click(By.cssSelector("[name=register-button]"));
        }

        public void fillRegistrationForm (String firstName, String lastName, String email, String password){
            app.getUser().click(By.cssSelector("input#gender-male"));

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

        @DataProvider
    public Iterator<Object[]> newUser() {
            List<Object[]> list = new ArrayList<>();
            list.add(new Object[]{"Max","Adams","maxx@gm.com","Max1234$"});
            list.add(new Object[]{"Max1","Adams","maxx@gm.com","Max1234$"});
            list.add(new Object[]{"Max2","Adams","maxx@gm.com","Max1234$"});

        return list.iterator();
        }

   /* @Test(dataProvider = "newUser")
    public void newUserRegistrationPositiveTestFromFDataProvider (String firstName,
                                                                  String lastName,
                                                                  String email,
                                                                  String password) {
        //fillRegistrationForm();
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password));


        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".register-continue-button")));
    }*/
    }

