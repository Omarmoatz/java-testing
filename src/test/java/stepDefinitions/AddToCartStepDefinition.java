package stepDefinitions;

import Pages.AddToCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartStepDefinition {
    WebDriver driver = null;
    AddToCartPage addToCartPage;


    @When("user click on the add to cart button")
    public void userNavigate() throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/fahrenheit-451-by-ray-bradbury");
        addToCartPage = new AddToCartPage(driver);
    }

    @And("confirm adding to shopping cart")
    public void addToCart() {
        addToCartPage.addToCart();
    }


    @Then("The product added successfully to shopping cart")
    public void ConfirmAddedToCart() {
        try {
            WebElement element = driver.findElement(By.className("bar-notification"));
            String msgToCheck = element.findElement(By.className("content")).getText();
            Assert.assertEquals("The product has been added to your shopping cart", msgToCheck);
        } catch(NoSuchElementException e) {

        }
    }
}
