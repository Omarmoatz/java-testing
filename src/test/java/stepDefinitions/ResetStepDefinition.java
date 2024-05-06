package stepDefinitions;

import Pages.ResetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetStepDefinition {
    public WebDriver driver = null;
    public ResetPage resetPage = null;


    @Then("user navigate to forgetPage and enter his email leqaahani@example.com")
    public void forgetPage(){
        driver = new ChromeDriver();
        resetPage = new ResetPage(driver);
        driver.navigate().to("https://demo.nopcommerce.com/passwordrecovery");
        resetPage.EnterEmail("leqaahani@example.com");
    }

    @And("user click on Recovery Button")
    public void ClickButton(){
        resetPage.SubmitUser();
    }


}
