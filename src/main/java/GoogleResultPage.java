import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleResultPage {
    private static final String CSS_SELECTOR_TO_FIND_SEARCH_RESULTS = ".h3, .LC20lb";

    private WebDriver browser;
    private List<WebElement> searchResults;

    public GoogleResultPage(WebDriver browser) {
        this.browser = browser;
        searchResults = browser.findElements(By.cssSelector(CSS_SELECTOR_TO_FIND_SEARCH_RESULTS));
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
