import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleStartPage {
    private static final String GOOGLE_ENGINE = "https://www.google.ru/";
    private static final String GOOGLE_QUERY_BOX_NAME = "q";

    private WebDriver browser;
    private WebElement queryBox;

    public GoogleStartPage(WebDriver browser) {
        this.browser = browser;
        browser.get(GOOGLE_ENGINE);
        queryBox = browser.findElement(By.name(GOOGLE_QUERY_BOX_NAME));
    }

    public WebDriver invokeSearch(String queryString) {
        queryBox.sendKeys(queryString);
        queryBox.submit();

        (new WebDriverWait(browser, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("r")));

        return browser;
    }

    String getPage() {
        return browser.getPageSource();
    }
}
