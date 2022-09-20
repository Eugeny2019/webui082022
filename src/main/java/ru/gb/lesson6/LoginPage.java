package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    public void setEmailField(String login) {
        emailField.sendKeys(login);
    }

    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public MyAccountPage login(String login, String password) {
        setEmailField(login);
        setPasswordField(password);
        clickSubmitButton();
        return new MyAccountPage(driver);
    }
}
