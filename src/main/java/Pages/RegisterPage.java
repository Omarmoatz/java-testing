package Pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");

    private By emailInput = By.id("Email");

    private By passwordInput = By.id("Password");

    private By passwordConfirmInput = By.id("ConfirmPassword");

    private By maleRadioButton = By.id("gender-male");

    private By femaleRadioButton = By.id("gender-female"), registerButton = By.id("register-button");


    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFirstName(String name) {
        driver.findElement(firstNameInput).sendKeys(name);
    }


    public void enterEmail(String name) {
        driver.findElement(emailInput).sendKeys(name);
    }


    public void enterLastName(String name) {
        driver.findElement(lastNameInput).sendKeys(name);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }


    public void enterPasswordConfirm(String passwordConfirm) {
        driver.findElement(passwordConfirmInput).sendKeys(passwordConfirm);
    }


    public void genderChoice(String gender) {
        if(gender == "male") {
            driver.findElement(maleRadioButton).click();
        } else {
            driver.findElement(femaleRadioButton).click();
        }
    }

    public void pressRegister() {
        driver.findElement(registerButton).click();
    }

}
