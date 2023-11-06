package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class CartPage {
    private WebDriver driver;

    By wishListLink = By.xpath("(//a[@href='http://live.techpanda.org/index.php/wishlist/'])[2]");
    By addToCartLink = By.xpath("//button[@title='Add to Cart']");
    By enterCountry = By.id("country");
    By enterRegion = By.id("region");
    By enterPostCode = By.id("postcode");
    By estimateLink = By.xpath("//span[text()='Estimate']");
    //    By shippingCostGenerated = By.xpath("//dt[text()='Flat Rate']");
    By chooseShippingCost = By.id("s_method_flatrate_flatrate");
    By updateTotal = By.xpath("//button[@class='button']");
    By checkOutProccess = By.xpath("(//button[@title='Proceed to Checkout'])[2]");

    By reOrderLink = By.xpath("//a[@class='link-reorder']");
    By enterQTY = By.xpath("//input[@class='input-text qty']");
    By updateQTYButton = By.xpath("//button[@title='Update']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Create methods for each action
    public void setWishListLink() {
        driver.findElement(wishListLink).click();
    }

    public void setAddToCartLink() {
        driver.findElement(addToCartLink).click();
    }

    public void setEnterCountry(String country) {
        WebElement countryElement = driver.findElement(enterCountry);
        countryElement.sendKeys(country);
    }

    public void setEnterRegion(String region) {
        WebElement regionElement = driver.findElement(enterRegion);
        regionElement.clear(); // clear the QTY before
        regionElement.sendKeys(region);
    }

    public void setEnterPostCode(String postCode) {
        WebElement postCodeElement = driver.findElement(enterPostCode);
        postCodeElement.clear(); // clear the QTY before
        postCodeElement.sendKeys(postCode);
    }

    public void setEstimateLink() {
        driver.findElement(estimateLink).click();
    }
//    public void setShippingCostGenerated() {
//        driver.findElement(shippingCostGenerated).click();
//    }

    public void setChooseShippingCost() {
        driver.findElement(chooseShippingCost).click();
    }

    public void setUpdateTotal() {
        driver.findElement(updateTotal).click();
    }

    public void setCheckOutProccess() {
        driver.findElement(checkOutProccess).click();
    }

    public void setReOrderLink() {
        driver.findElement(reOrderLink).click();
    }

    public void setEnterQTY(String qty) {
        WebElement qtyElement = driver.findElement(enterQTY);
        qtyElement.clear(); // clear the QTY before
        qtyElement.sendKeys(qty);
    }

    public void setUpdateQTYButton() {
        driver.findElement(updateQTYButton).click();
    }
}