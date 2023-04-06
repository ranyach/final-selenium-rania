package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HighTechPage {

    By highTechElementsLocator = By.cssSelector(".p13n-gridRow > div");
    WebDriver driver;

    public HighTechPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage selectBestHighTechProduct(int index){
     List<WebElement> items =  driver.findElements(highTechElementsLocator);
              items.get(index).click();
       return new ProductPage(driver);
    }
}
