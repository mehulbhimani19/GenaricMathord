import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DriverManager
{
    WebDriver driver;
    String baseURL;
    private GenericMethords gm;
    @BeforeMethod

    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        baseURL =  "https://letskodeit.teachable.com/pages/practice";
        driver.get(baseURL);
        // Create object for Generic Mathords
        gm = new GenericMethords(driver);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }

    @Test
    public void test ()
    {
        WebElement element = gm.getElement("name", "id");
        element.sendKeys("testing");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
