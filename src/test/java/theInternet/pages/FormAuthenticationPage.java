package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import supports.Browser;

public class FormAuthenticationPage {
    WebDriver driver;
    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.cssSelector("button[type=submit]");
    By successfulFlashMessage = By.className("success");
    By unsuccessfulFlashMessage = By.className("error");

    public FormAuthenticationPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login (String username, String password) {
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoggedIn() {
        return driver.findElement(successfulFlashMessage).getText().contains("You logged into a secure area!");
    }

    public boolean isNotLoggedInWhenWrongUsername() {
        return driver.findElement(unsuccessfulFlashMessage).getText().contains( "Your username is invalid!");
    }

    public boolean isNotLoggedInWhenWrongPassword() {
        return driver.findElement(unsuccessfulFlashMessage).getText().contains( "Your password is invalid!");
    }
}
