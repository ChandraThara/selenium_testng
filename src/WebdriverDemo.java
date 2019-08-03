import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverDemo {
    public static void main( String args[]) {
        //System.setProperty("webdriver.gecko.driver","/Users/thara/Work/Selenium/geckodriver");
        System.setProperty("webdriver.chrome.driver","/Users/thara/Work/Selenium/chromedriver");

//        WebDriver driver = new FirefoxDriver(); // launches a new browser
//        driver.get("http://www.google.com");//opens up site

//        WebDriver driver = new ChromeDriver(); // launches a new browser
//        driver.get("http://www.google.com");//opens up site

        WebDriver driver = new SafariDriver(); // launches a new browser
        //driver.get("http://www.google.com");//opens up site

        // findElement(By.id)/(By.name),By.class etc
        // findElements(By.tagName)

        driver.get("https://search.yahoo.com");//opens up site
        WebElement element = driver.findElement(By.id("yschsp"));
        element.sendKeys("java training");
        element.submit();



    }

}
