import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage {
    private static final String CSS_SELECTOR_TO_FIND_SEARCH_RESULTS = ".h3, .LC20lb";

    private WebDriver browser;
    @FindBy(css = CSS_SELECTOR_TO_FIND_SEARCH_RESULTS)
    private List<WebElement> searchResults;

    public GoogleResultPage(WebDriver browser) {
        PageFactory.initElements(browser, this);
        this.browser = browser;
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    String getPage() {
        return browser.getPageSource();
    }

    public void close() {
        browser.close();
    }
}
