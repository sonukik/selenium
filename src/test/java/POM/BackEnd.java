package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class BackEnd {
    WebDriver driver;
    //Define your locators at the top of the class
    By enterUserName = By.id("username");
    By enterPassword = By.name("login[password]");
    By loginClick = By.className("form-button");

    By orderLink = By.xpath("//span[text()='Orders']");

    By enterOrder = By.id("sales_order_grid_filter_real_order_id");

    By enterFromDay = By.name("created_at[from]");
    By enterToDay = By.name("created_at[to]");

    By searchClick = By.xpath("//span[text()='Search']");


    public BackEnd(WebDriver driver) {
        this.driver = driver;
    }

    public void setEnterUserName(String username) {
        WebElement userNameElement = driver.findElement(enterUserName);
        userNameElement.clear(); // clear the QTY before
        userNameElement.sendKeys(username);
    }

    public void setEnterPassword(String password) {
        WebElement passwordElement = driver.findElement(enterPassword);
        passwordElement.clear(); // clear the QTY before
        passwordElement.sendKeys(password);
    }

    public void setLoginClick() {
        driver.findElement(loginClick).click();
    }

    public void setOrderLink() {
        driver.findElement(orderLink).click();
    }

    public void setEnterOrder(String order) {
        WebElement fromDayElement = driver.findElement(enterOrder);
        fromDayElement.clear(); // clear the Day before
        fromDayElement.sendKeys(order);
    }

    public void setEnterFromDay(String from) {
        WebElement fromDayElement = driver.findElement(enterFromDay);
        fromDayElement.clear(); // clear the Day before
        fromDayElement.sendKeys(from);
    }

    public void setEnterToDay(String to) {
        WebElement toDayElement = driver.findElement(enterToDay);
        toDayElement.clear(); // clear the Day before
        toDayElement.sendKeys(to);
    }

    public void setSearchClick() {
        driver.findElement(searchClick).click();
    }
}
