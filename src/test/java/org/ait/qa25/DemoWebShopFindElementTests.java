package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoWebShopFindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        //maximize browser window
        driver.manage().window().maximize();
        //set implicit timeout - neyavnoe ozhidanie
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void findElementByCssTest(){
        driver.findElement(By.cssSelector("head"));
        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector(".master-wrapper-page"));
        driver.findElement(By.cssSelector(".search-box"));
        driver.findElement(By.cssSelector("[name=generator]"));
        driver.findElement(By.cssSelector("[class*=logo]"));
        driver.findElement(By.cssSelector("[class*=manufacturer]"));
        driver.findElement(By.cssSelector("[class^=left]"));
        driver.findElement(By.cssSelector("[class$=main]"));
    }

    @Test
    public void findElementByXpathTest() {
        driver.findElement(By.xpath("//head"));
        driver.findElement(By.xpath("//*[@id='dialog-notifications-success']"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));
        driver.findElement(By.xpath("//*[@class='master-wrapper-page']"));
        driver.findElement(By.xpath("//*[@class='search-box']"));
        driver.findElement(By.xpath("//*[@name='generator']"));
        driver.findElement(By.xpath("//*[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//*[contains(@class,'manufacturer')]"));
        driver.findElement(By.xpath("//*[starts-with(@class,'left')]"));
        driver.findElement(By.xpath("//*[starts-with(@class,'left')]"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
