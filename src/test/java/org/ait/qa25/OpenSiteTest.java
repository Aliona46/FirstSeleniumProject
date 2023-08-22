package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    //before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        //driver.get("https://www.google.com");
        driver.navigate().to("https://www.google.com"); // with history
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    //tests (nazvanie liuboe, no ponyatnoe)
    @Test
    public void openGoogleTest() {
        System.out.println("Site is opened!");
    }

    //after - tearDown
    @AfterMethod
    public void tearDown() {
        driver.quit(); // all tabs & browser close
        //driver.close(); // close only one tab,but if its only one - than close browser too
    }
}
