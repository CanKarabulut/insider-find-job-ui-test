package insider.findjob;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindJobTests extends BaseTest {

    private HomePage homePage;
    private CareerPage careerPage;
    private QAJobsPage qaJobsPage;
    @Test(priority = 1)
    public void testHomePage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        homePage.acceptCookies();
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void testCareerPage() {
        careerPage = new CareerPage(driver);
        careerPage.navigateToCareerPage();
        Assert.assertTrue(careerPage.isCareersPageOpened());
        Assert.assertTrue(careerPage.areBlocksDisplayed());
    }

    @Test(priority = 3)
    public void testQAJobsPage() throws InterruptedException {
        qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.navigateToQAJobsPage();
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.filterJobsByLocationAndDepartment("Istanbul, Turkey", "Quality Assurance");
    }

    @Test(priority = 4)
    public void testJobDetails() throws InterruptedException {
        qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.verifyJobDetails();

    }

    @Test(priority = 5)
    public void testViewRoleButton() throws InterruptedException {
        qaJobsPage = new QAJobsPage(driver);
        qaJobsPage.clickViewRoleButtonAndVerify();
    }
}
