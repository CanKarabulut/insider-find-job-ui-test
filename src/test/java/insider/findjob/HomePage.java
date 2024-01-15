package insider.findjob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://useinsider.com/");
    }

    public void acceptCookies() {
        WebElement cookiesAccept = driver.findElement(By.id("wt-cli-accept-all-btn"));
        cookiesAccept.click();
    }
}
