package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class IndexPage {
    WebDriver driver;

    By mobileLink = By.linkText("MOBILE");
    By addToCartLink = By.xpath("//button[@title='Add to Cart']");
    By enterCouponCode = By.id("coupon_code");
    By applyClick = By.xpath("//span[text()='Apply']");


    // Create methods for each action
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setMobileLink() {
        driver.findElement(mobileLink).click();
    }

    public void setAddToCartLink() {
        driver.findElement(addToCartLink).click();
    }

    public void setEnterCouponCode(String region) {
        WebElement regionElement = driver.findElement(enterCouponCode);
        regionElement.clear(); // clear the coupon before
        regionElement.sendKeys(region);
    }

    public void setApplyLink() {
        driver.findElement(applyClick).click();
    }
}
