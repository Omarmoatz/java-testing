package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");

    private By loginButton = By.className("login-button");


    private By forgotPassword = By.cssSelector("a[href='/passwordrecovery']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }


    public void clickForgotPassword() {
        driver.findElement(forgotPassword).click();
    }
}
