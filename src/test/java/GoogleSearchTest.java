import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class GoogleSearchTest {
    private static final String QUERY_STRING = "Java";

    private GoogleStartPage googleStartPage;
    private GoogleResultPage googleResultPage;

    @BeforeClass
    public void setUp() {
        googleStartPage = new GoogleStartPage(new ChromeDriver());
    }

    @Test
    private void isPageChangedTest() {
        String pageBeforeQuery = googleStartPage.getPage();
        googleResultPage = new GoogleResultPage(googleStartPage.invokeSearch(QUERY_STRING));
        String pageAfterQuery = googleResultPage.getPage();
        assertNotEquals(pageBeforeQuery, pageAfterQuery);
    }

    @Test(dependsOnMethods = "isPageChangedTest")
    private void isIncludeEachResultQueryWord() {
        List<WebElement> queryResults = googleResultPage.getSearchResults();
        for (WebElement queryResult: queryResults) {
            assertTrue(queryResult.getText().toLowerCase().contains(QUERY_STRING.toLowerCase()));
        }
    }

    @AfterClass
    public void closeDriver() {
        googleResultPage.close();
    }
}
