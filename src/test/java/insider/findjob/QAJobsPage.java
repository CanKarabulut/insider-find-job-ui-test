package insider.findjob;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class QAJobsPage {

    private WebDriver driver;

    public QAJobsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToQAJobsPage() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
    }

    public void clickSeeAllQAJobs() throws InterruptedException {
        WebElement seeAllQAJobs = driver.findElement(By.linkText("See all QA jobs"));
        seeAllQAJobs.click();
        Thread.sleep(5000);
    }

    public void filterJobsByLocationAndDepartment(String location, String department) throws InterruptedException {
        driver.findElement(By.id("select2-filter-by-location-container")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector("[id*='" + location + "']")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("select2-filter-by-department-container")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[id*='" + department + "']")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.id("jobs-list")).isDisplayed());
        Thread.sleep(5000);
    }

    public void verifyJobDetails() {
        WebElement jobsList = driver.findElement(By.id("jobs-list"));
        for (WebElement job : jobsList.findElements(By.className("position-list-item"))) {
            verifyJobTitle(job);
            verifyJobDepartment(job);
            verifyJobLocation(job);
        }
    }

    private void verifyJobTitle(WebElement job) {
        Assert.assertTrue(job.findElement(By.className("position-title")).getText().contains("Software"));
    }

    private void verifyJobDepartment(WebElement job) {
        Assert.assertTrue(job.findElement(By.className("position-department")).getText().contains("Quality Assurance"));
    }

    private void verifyJobLocation(WebElement job) {
        Assert.assertTrue(job.findElement(By.className("position-location")).getText().contains("Istanbul, Turkey"));
    }

    public void clickViewRoleButtonAndVerify() throws InterruptedException {
        WebElement job = driver.findElement(By.className("position-list-item-wrapper"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", job);
        Thread.sleep(10000);
        job.findElement(By.tagName("a")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.getCurrentUrl().contains("useinsider"));
        Thread.sleep(3000);
    }

}