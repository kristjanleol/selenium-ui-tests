import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaxLoanCalculator extends PageObject {


    private final String MIN_INCOME = "550";
    private final String MID_INCOME = "1700";
    private final String HIGH_INCOME = "3000";
    private final String LESS_THAN_MINIMUM_INCOME = "400";
    private final String LESS_THAN_MINIMAL_MESSAGE = "Taotleja minimaalne netopalk peab olema 550 eurot";
    private final String LOG_IN_VIEW_MESSAGE = "Palun tuvasta ennast";
    private final String SUBMIT_BUTTON = "ESITA TAOTLUS";


    @FindBy(id = "edit-monthly-income")
    private WebElement income_field;

    @FindBy(xpath = "//*[@id=\"loan-tab--2\"]/div/div[8]/div/p")
    private WebElement less_than_minimal_message;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[4]/div/div/div[4]")
    private WebElement log_in_view_message;


    @FindBy(xpath = "//*[@id=\"loan-tab--2\"]/div/div[11]/div/p/a")
    private WebElement submit_button;

    public MaxLoanCalculator(WebDriver driver) {
        super(driver);
    }

    public void pressSubmitButton() {
        if (this.submit_button.getText().equals(SUBMIT_BUTTON)) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("arguments[0].click();", submit_button);
        }
    }

    public void scrollPage() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500)");
    }

    public void enterMinimalIncome() {
        clearField(income_field);
        this.income_field.sendKeys(MIN_INCOME);
    }

    public void enterMidIncome() {
        clearField(income_field);
        this.income_field.sendKeys(MID_INCOME);
    }

    public void enterHighIncome() {
        clearField(income_field);
        this.income_field.sendKeys(HIGH_INCOME);
    }

    public void enterLessThanMinimumIncome() {
        clearField(income_field);
        this.income_field.sendKeys(LESS_THAN_MINIMUM_INCOME);
    }

    public boolean lessThanMinimalMessageIsPresent() {
        return this.less_than_minimal_message.getText().equals(LESS_THAN_MINIMAL_MESSAGE);
    }

    public boolean logInViewMessageIsPresent() {
        return this.log_in_view_message.getText().equals(LOG_IN_VIEW_MESSAGE);
    }

    public void waitForpageToLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearField(WebElement element) {
        element.clear();
    }
}