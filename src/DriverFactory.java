import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    //singletong design pattern
    private static final DriverFactory instance = new DriverFactory();
    private DriverFactory() {

    }
    public static DriverFactory getInstance() {
        return instance;
    }

    //factory design pattern
//    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>() {
//        protected   WebDriver initialValue() {
//            return new ChromeDriver();
//        }
//    };

    //factory pattern
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public WebDriver getDriver(BrowserType type) {
        if (threadLocal.get() == null) {
            switch (type) {
                case CHROME:
                    threadLocal.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    threadLocal.set(new FirefoxDriver());
                    break;
                default:
                    break;
            }
        }
        return threadLocal.get();
    }


    public WebDriver getDriver() {
        return threadLocal.get();
    }

    //sample singleton design pattern code
    /*
    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){
    }
    public static Singleton getInstance(){
        return INSTANCE;
    }
     */
}
