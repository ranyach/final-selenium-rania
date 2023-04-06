package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    By quantityLocator = By.cssSelector("#quantity");
    By addToCartButton = By.id("add-to-cart-button");

    By cartButtonLocator = By.cssSelector("#attach-sidesheet-view-cart-button");

    By titleLocator = By.id("productTitle");
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage updateQuantity(int index) {
        WebElement quantityElement = driver.findElement(quantityLocator);
        Select quantityDropdown = new Select(quantityElement);
        quantityDropdown.selectByIndex(index);
        return this;
    }

    public CartPage addToCart(){
        driver.findElement(addToCartButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator)).click();
        return new CartPage(driver);
    }

    public String productTitle(){
        return driver.findElement(titleLocator).getText();
    }
}
