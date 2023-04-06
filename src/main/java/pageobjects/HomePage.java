package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    By cookiesLocator = By.id("sp-cc-accept");
    By bestSellerLocator = By.cssSelector("[data-csa-c-content-id='nav_cs_bestsellers']");
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage acceptCookies(){
        driver.findElement(cookiesLocator).click();
        return this;
    }
    public BestSellerPage goToBestSellersPage(){
        driver.findElement(bestSellerLocator).click();
        return new BestSellerPage(driver);
    }

}
