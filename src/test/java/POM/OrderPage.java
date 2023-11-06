package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;
    By myOrderLink = By.linkText("MY ORDERS");
    By viewOrderLink = By.xpath("//span[@class='nobr']//a");
    By printOrderLink = By.linkText("Print Order");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setMyOrderLink() {
        driver.findElement(myOrderLink).click();
    }

    public void setViewOrderLink() {
        driver.findElement(viewOrderLink).click();
    }

    public void setPrintOrderLink() {
        driver.findElement(printOrderLink).click();
    }
}
