package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
@Test
public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By myAccountLink = By.linkText("MY ACCOUNT");
    By enterEmailAddress = By.id("email");
    By enterPassword = By.id("pass");
    By loginButton = By.xpath("//button[@class='button']");
    public void myAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void enterEmailAddress(String emailAddress) {
        WebElement emailAddressElement = driver.findElement(enterEmailAddress);
        emailAddressElement.clear(); // clear the QTY before
        emailAddressElement.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(enterPassword);
        passwordElement.clear(); // clear the QTY before
        passwordElement.sendKeys(password);
    }

    public void loginButton() {
        driver.findElement(loginButton).click();
    }
}
