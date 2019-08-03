import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsDemo {
    WebDriver driver;

    @BeforeClass
    void setUpClass() {
        System.out.println("BeforeClass----------->");
        System.setProperty("webdriver.chrome.driver","/Users/thara/Work/Selenium/chromedriver");
    }

    @AfterClass
    void tearDownClass() {
        System.out.println("AfterClass----------->");
        System.clearProperty("webdriver.chrome.driver");
    }

    @BeforeMethod
    void setUpMethod() {
        System.out.println("BeforeTest----------->");
        driver= new ChromeDriver();
        driver.get("http://www.google.com");
    }

    @AfterMethod
    void tearDownMethod() {
        System.out.println("AfterTest----------->");
        driver.quit();
    }

    @Test
    void calcTest() {
        System.out.println("calcTest----------->");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("2+3");
        element.submit();

        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(),"5");

    }

    @Test
    void calcTest2() {
        System.out.println("calcTest2----------->");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("sqrt 16");
        element.submit();

        WebElement result = driver.findElement(By.id("cwos"));
        Assert.assertEquals(result.getText(),"4");
    }


}
