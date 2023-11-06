package BaiTap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.isSorted;
import static org.openqa.selenium.By.*;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class Testcase1 {

    public static void verifyApplicationTitle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");
        driver.get("http://live.techpanda.org/index.php/mobile.html");
        String my_title = driver.getTitle();
        System.out.println("Title is " + my_title);
        //Click on the " MOBILE " menu
        driver.findElement(linkText("MOBILE")).click();
        // Select "SORT BY" dropdown as "Name"
        WebElement element = driver.findElement(By.xpath("//select[@onchange='setLocation(this.value)']"));
        Select select = new Select(element);
        select.selectByVisibleText("Name");
        List<WebElement> productElements = driver.findElements(By.cssSelector(".product-name"));
        ArrayList<String> productNames = new ArrayList<>();
        for (WebElement product : productElements) {
            productNames.add(product.getText());
        }

// Check if the list of product names is sorted
        boolean isSorted = true;
        for (int i = 1; i < productNames.size(); i++) {
            if (productNames.get(i - 1).compareTo(productNames.get(i)) > 0) {
                isSorted = false;
                break;
            }
        }

        if (isSorted) {
            System.out.println("Products are sorted by name.");
        } else {
            System.out.println("Products are not sorted by name.");
        }
    }
}






