import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "T_ID_01")
    public void submitFormMinIncome() {
        driver.get(Utils.BASE_URL);
        MaxLoanCalculator maxLoanCalculator = new MaxLoanCalculator(driver);
        driver.manage().window().maximize();
        maxLoanCalculator.enterMinimalIncome();
        maxLoanCalculator.scrollPage();
        maxLoanCalculator.pressSubmitButton();
        maxLoanCalculator.waitForpageToLoad();
        Assert.assertTrue(maxLoanCalculator.logInViewMessageIsPresent());
    }


    @Test(testName = "T_ID_01_2")
    public void submitFormMidIncome() {
        driver.get(Utils.BASE_URL);
        MaxLoanCalculator maxLoanCalculator = new MaxLoanCalculator(driver);
        maxLoanCalculator.enterMidIncome();
        maxLoanCalculator.pressSubmitButton();
        maxLoanCalculator.waitForpageToLoad();
        Assert.assertTrue(maxLoanCalculator.logInViewMessageIsPresent());

    }

    @Test(testName = "T_ID_01_3")
    public void submitFormHighIncome() {
        driver.get(Utils.BASE_URL);
        MaxLoanCalculator maxLoanCalculator = new MaxLoanCalculator(driver);
        maxLoanCalculator.enterHighIncome();
        maxLoanCalculator.pressSubmitButton();
        maxLoanCalculator.waitForpageToLoad();
        Assert.assertTrue(maxLoanCalculator.logInViewMessageIsPresent());

    }

    @Test(testName = "T_ID_07")
    public void lessThanMinimalIncomeMessage() {
        driver.get(Utils.BASE_URL);
        MaxLoanCalculator maxLoanCalculator = new MaxLoanCalculator(driver);
        maxLoanCalculator.enterLessThanMinimumIncome();
        Assert.assertTrue(maxLoanCalculator.lessThanMinimalMessageIsPresent());
    }

    @AfterSuite
    public void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}