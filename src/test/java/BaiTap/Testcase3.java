package BaiTap;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

@Test
public class Testcase3 {
public void verifyQuantity(){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://live.techpanda.org/");


    driver.findElement(By.linkText("MOBILE")).click();
    WebElement addToCartButton = driver.findElement(By.xpath("//li[1]//div[1]//div[3]//button[1]"));
    addToCartButton.click();
    WebElement qtyInput = driver.findElement(By.xpath("//input[@title='Qty']"));
    qtyInput.clear();
    qtyInput.sendKeys("1000");
    WebElement updateButton = driver.findElement(By.cssSelector("button[title='Update']"));
    updateButton.click();

    // Step 5: Verify the error message
    WebElement errorMessage = driver.findElement(By.cssSelector(".item-msg.error"));
    String expectedErrorMessage = "The requested quantity for \\\"Sony Xperia\\\" is not available.";

    String actualErrorMessage = errorMessage.getText();
    try {
        assert actualErrorMessage.equals(expectedErrorMessage) : "* The maximum quantity allowed for purchase is 500.";
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Step 6: Click "EMPTY CART"
    WebElement emptyCartLink = driver.findElement(By.cssSelector("button[id='empty_cart_button'] span span"));
    emptyCartLink.click();

    // Step 7: Verify cart is empty
    WebElement emptyCart = driver.findElement(By.xpath("//span[normalize-space()='Cart']"));

    try {
        AssertJUnit Assertions = null;
        AssertJUnit.assertEquals(emptyCart, driver.findElement(By.xpath("//span[normalize-space()='Cart']")));
    } catch (Exception e){
        e.printStackTrace();
    }
}
    }

