package org.ait.qa25.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemHelper extends HelperBase{
    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartLink() {
        click(By.cssSelector("a.ico-cart span.cart-label"));
    }

    public void clickOnAddToCartButton() {
        click(By.cssSelector("#add-to-cart-button-31"));
    }

    public void clickOnItemIcon() {
        click(By.cssSelector("img[src='https://demowebshop.tricentis.com/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
    }

    public void removeItem() {
        click(By.cssSelector("[name=removefromcart]"));
        click(By.cssSelector("[name=updatecart]"));
    }

    public boolean isItemAdded() {
        return isElementPresent2(By.cssSelector("td.product a.product-name"));
    }
}
