package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPage {
    public WebDriver driver;
    public By emailInputField = By.id("Email");
    public By submitButtonRecovery = By.className("password-recovery-button");

    public void EnterEmail(String email){
        driver.findElement(emailInputField).sendKeys(email);
    }
    public void SubmitUser(){
        driver.findElement(submitButtonRecovery).click();
    }
    public ResetPage(WebDriver driver){
        this.driver = driver;
    }

}
