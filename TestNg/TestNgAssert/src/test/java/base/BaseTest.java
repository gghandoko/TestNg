package base;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String driverPath = "/src/test/java/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
        System.out.println("=== Setup dijalankan ===");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        System.out.println("=== Browser terbuka ===");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("=== Teardown dijalankan ===");
        try {
            Thread.sleep(5000); // tunggu 10 detik sebelum close
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
