package stepDefinitions;

import Pages.RegisterPage;
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

public class registerStepDefinitions {
    WebDriver driver = null;
    RegisterPage registerPage;

    @Given("User go to register page")
    public void enterRegisterPage() throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://demo.nopcommerce.com/register");
        registerPage = new RegisterPage(driver);
    }


    @And("User enter the email")
    public void userEnterEmail() {
        registerPage.enterEmail("mohannedahmd@gmail.com");
    }


    @And("User enter the first and last name")
    public void userEnterName() {
        registerPage.enterFirstName("Mohanned Ahmed");
        registerPage.enterLastName("Elalfy");
    }

    @And("User enter and confirm the password")
    public void userEnterPassword() {
        registerPage.enterPassword("123456");
        registerPage.enterPasswordConfirm("123456");
    }


    @When("User select the type of gender")
    public void userChoosesHisGender() {
        registerPage.genderChoice("male");
    }


    @And("User click on register button")
    public void userHitsRegisterButton() throws InterruptedException {
        registerPage.pressRegister();
        Thread.sleep(1000);
    }

    @Then("success message is displayed")
    public void checkSuccess() {
        try {
            WebElement msgSucess = driver.findElement(By.className("result"));
            Assert.assertEquals("Your registration completed", msgSucess.getText());
        } catch(NoSuchElementException e) {

        }
    }
}
