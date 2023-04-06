package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BestSellerPage {
    By bestItemsLocator = By.cssSelector("[role='group']  > div >a");
    WebDriver driver;

    public BestSellerPage(WebDriver driver){
        this.driver = driver;
    }

    public HighTechPage goToHighTechPage(){
      driver.findElements(bestItemsLocator).get(19).click();
      return new HighTechPage(driver);
    }
}
