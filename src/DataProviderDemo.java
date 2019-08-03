import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


    public class DataProviderDemo {
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



        @Test(dataProvider = "calc-test", dataProviderClass = TestData.class)
        void calcTest(String input, String expected) {
            System.out.println("calcTest----------->");

            WebElement element = driver.findElement(By.name("q"));
            element.sendKeys(input);
            element.submit();

            WebElement result = driver.findElement(By.id("cwos"));
            Assert.assertEquals(result.getText(),expected);

        }

    }

