import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
     //   driver.quit();
    }

    @Test
    public void tpFinal(){
        driver.get("https://www.amazon.fr");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.acceptCookies()
                .goToBestSellersPage()
                .goToHighTechPage()
                .selectBestHighTechProduct(2)
                .updateQuantity(1);
        String productTitleInProductPage = productPage.productTitle();
        CartPage cartPage = productPage.addToCart();

        Assert.assertEquals(productTitleInProductPage, cartPage.productTitle(), "le titre dans la page produit et page panier n'est pas identique !" );

       Assert.assertEquals(cartPage.quantity(), "2", "La quantité ne vaut pas 2 ");
    }
}
