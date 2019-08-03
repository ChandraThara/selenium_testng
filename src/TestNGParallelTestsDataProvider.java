import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGParallelTestsDataProvider {


    @BeforeClass
    void setUpClass() {
        System.out.println("BeforeClass----------->");
        System.setProperty("webdriver.chrome.driver", "/Users/thara/Work/Selenium/chromedriver");
    }



    @DataProvider(name = "search-test",parallel=true)
    Object[][] testData() {
        return new Object[][]{
                {"TestNG"},
                {"Selenium WebDriver"}
        };
    }

        @Test(dataProvider = "search-test")
        void searchTest (String searchText) {
            WebDriver driver = new ChromeDriver();
            driver.get("http://www.google.com");

            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys(searchText);
            element.submit();

            Assert.assertTrue(driver.getTitle().startsWith(searchText));

            System.out.println(searchText+":"+Thread.currentThread().getId()+":"+Thread.currentThread().getName());

        }

    }




