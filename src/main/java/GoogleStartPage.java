import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleStartPage {
    private static final String GOOGLE_ENGINE = "https://www.google.ru/";
    private static final String GOOGLE_QUERY_BOX_NAME = "q";

    private WebDriver browser;

    @FindBy(how = How.NAME, name = GOOGLE_QUERY_BOX_NAME)
    private WebElement queryBox;

    public GoogleStartPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
        this.browser = browser;
        browser.get(GOOGLE_ENGINE);
    }

    public GoogleResultPage invokeSearch(String queryString) {
        queryBox.sendKeys(queryString);
        queryBox.submit();

        (new WebDriverWait(browser, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("r")));

        return new GoogleResultPage(browser);
    }

    String getPage() {
        return browser.getPageSource();
    }
}
