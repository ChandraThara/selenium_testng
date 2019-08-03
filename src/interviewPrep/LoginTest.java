package interviewPrep;

/*
    Q.Implement a method named loginTest for the following scenario.
    * step1 - Navigate to a web page that has a 'SIGN IN' link. Click it
    * step2 - It opens up a new tab to sign in, navigate to that tab
    * step3 - Enter username/password and hit Next
    * step4 - You will be signed in. Verify that profile image is displayed

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver driver;
    @BeforeMethod
    void setUpMethod() {
        System.setProperty("webdriver.chrome.driver","/Users/thara/Work/Selenium/chromedriver");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    void loginTest() {
        //step1 - Navigate to a web page that has a 'SIGN IN' link. Click it

        driver.get("https://artsandculture.google.com/");
        driver.findElement(By.linkText("Sign in")).click();

        //step2 - It opens up a new tab to sign in, navigate to that tab

        Set<String> tabs = driver.getWindowHandles();
        for( String tab :tabs ) {
            driver.switchTo().window(tab);
            if(driver.getTitle().equals("Sign in - Google Accounts")) {
                break;
            }
        }

        //step3 - Enter username/password and hit Next

        driver.findElement(By.id("identifierId")).sendKeys("******");//provide valid EmailId
        driver.findElement(By.id("identifierNext")).click();

        driver.findElement(By.name("password")).sendKeys("*******");//provide valid password
        WebDriverWait wait = new WebDriverWait(driver,6);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("passwordNext")));
        driver.findElement(By.id("passwordNext")).click();

        //step4 - You will be signed in. Verify that profile image is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='Vh1kbe mR1q3']")).isDisplayed());

    }
}
