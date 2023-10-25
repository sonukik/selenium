package BaiTap;


   import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
   import org.openqa.selenium.support.ui.ExpectedConditions;
   import org.openqa.selenium.support.ui.WebDriverWait;
   import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

   import java.time.Duration;

   import static org.testng.Assert.assertEquals;

    @Test
    public class VerifyProductCost {
        public void verifyProductCostEquality() {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://live.techpanda.org/");

            // Click on the "MOBILE" menu
            driver.findElement(By.linkText("MOBILE")).click();
            // Explicit wait for the "Sony Xperia" link to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement sonyXperiaLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Sony Xperia')]")));

            // Find the cost of Sony Xperia mobile on the list page
            WebElement sonyXperiaMobile = driver.findElement(By.xpath("//a[contains(text(),'Sony Xperia')]/following::span[@class='price']"));
            String costOnListPage = sonyXperiaMobile.getText();

            // Click on the Sony Xperia mobile link
            sonyXperiaLink.click();

            // Find the cost of Sony Xperia mobile on the details page
            WebElement costOnDetailsPageElement = driver.findElement(By.xpath("//span[@class='price']"));
            String costOnDetailsPage = costOnDetailsPageElement.getText();

            // Compare the product cost on the list and details pages
            assertEquals(costOnListPage, costOnDetailsPage, "Product cost on list and details page is not equal.");

            // Close the browser
            driver.quit();
        }
    }


