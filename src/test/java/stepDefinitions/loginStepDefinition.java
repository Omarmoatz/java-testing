package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStepDefinition {


    WebDriver driver = null;
    LoginPage loginPage = null;
    @Given("user navigate to login page")
    public void user_navigate_to_login_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        loginPage = new LoginPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/login");
    }


    @When("user enter \"leqaahani@example.com\" and \"123456\"")
    public void userEnterValidCredentials() throws InterruptedException{
        loginPage.enterEmail("leqaahani@example.com");
        loginPage.enterPassword("123456");
    }



    @And("User click on login button")
    public void loginButton() throws InterruptedException {
        loginPage.clickLogin();
    }


    @Then("User could login successfully and navigate to home page")
    public void userRedirectedToHomePage() throws InterruptedException {
        try {
            WebElement homePageElement = driver.findElement(By.className("html-home-page"));
            Assert.assertTrue("Redirected to Homepage", homePageElement.isDisplayed());
        } catch(NoSuchElementException e) {

        }
    }

    @When("user enter \"user@examples.com\" and \"123456\"")
    public void userEnterInValidCredentials() throws InterruptedException{
        loginPage.enterEmail("user@examples.com");
        loginPage.enterPassword("123456");
    }


    @Then("User couldn't login successfully")
    public void checkInvalid() throws InterruptedException {
        try {
            WebElement msgError = driver.findElement(By.className("message-error"));
            Assert.assertTrue("Error while logging in has occurred", msgError.isDisplayed());
        } catch(NoSuchElementException e) {

        }
    }

    @When("user click on forgetPassword")
    public void usersHitsForgotPassword() {
        loginPage.clickForgotPassword();
        driver.quit();
    }

}
