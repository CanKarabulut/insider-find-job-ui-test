package insider.findjob;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setupDriver(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = getClass().getClassLoader().getResource("chromedriver").getPath();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            String geckoDriverPath = getClass().getClassLoader().getResource("geckodriver").getPath();
            System.setProperty("webdriver.gecko.driver", geckoDriverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    private void captureScreenshot(String methodName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot saved: " + screenshotFile.getPath());

    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getMethod().getMethodName());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
