import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGParallelTestsUsingBaseClass extends BaseTest {

    //WebDriver driver;


    @Test
    void calcTest() {
        WebDriver driver = getDriver();

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("2+3");
        element.submit();

        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(),"5");

    }

    @Test
    void searchTest() {
        WebDriver driver = getDriver(BrowserType.FIREFOX,"http://www.google.com");
        //WebDriver driver = getDriver();

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();
        System.out.println("driver.getTitle()----"+driver.getTitle());


        Assert.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));

    }
}

