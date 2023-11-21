package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void SetUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement secureArea = driver.findElement(By.className("title"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea.getText());
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement secureArea = driver.findElement(By.className("title"));
        System.out.println(secureArea.getText());
        Assert.assertEquals("Incorrect Login detail", "PRODUCTS", secureArea.getText());

        List<WebElement> verifydisplaylist = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']\n"));
        System.out.println("Item display  : " + verifydisplaylist.size());

        for (WebElement itemcount : verifydisplaylist) {
            System.out.println("Total number of item display  : " + itemcount);
        }
    }
}
