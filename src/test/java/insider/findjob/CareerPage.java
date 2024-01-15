package insider.findjob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareerPage {

    private WebDriver driver;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCareerPage() {
        WebElement companyMenu = driver.findElement(By.linkText("Company"));
        companyMenu.click();

        WebElement careersSubMenu = driver.findElement(By.linkText("Careers"));
        careersSubMenu.click();
    }

    public boolean isCareersPageOpened() {
        return driver.getTitle().contains("Careers");
    }

    public boolean areBlocksDisplayed() {
        return driver.findElement(By.linkText("Find your dream job")).isDisplayed() &&
                driver.findElement(By.className("elementor-widget-wp-widget-insider-locations")).isDisplayed() &&
                driver.findElement(By.linkText("See all teams")).isDisplayed() &&
                driver.findElement(By.cssSelector("[data-id='" + "87842ec" + "']")).isDisplayed();
    }
}
