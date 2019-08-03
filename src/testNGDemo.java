import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class testNGDemo {
    @Test
    void calcTest() {
        System.setProperty("webdriver.chrome.driver","/Users/thara/Work/Selenium/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("2+3");
        element.submit();

        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(),"5");
    }
}

