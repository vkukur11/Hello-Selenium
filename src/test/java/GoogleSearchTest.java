import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class GoogleSearchTest {
    private static final String QUERY_STRING = "Java";

    private Query query;

    @BeforeSuite
    public void setUp() {
        query = new Query();
        query.openGoogle();
    }

    @Test(priority = 1)
    private void isPageChangedTest() {
        String pageBeforeQuery = query.getPage();
        query.search(QUERY_STRING);
        String pageAfterQuery = query.getPage();
        assertNotEquals(pageBeforeQuery, pageAfterQuery);
    }

    @Test(priority = 2)
    private void isIncludeEachResultQueryWord() {
        List<WebElement> queryH3Results = query.getAllResults();
        for (WebElement queryH3Result: queryH3Results) {
            assertTrue(queryH3Result.getText().toLowerCase().contains(QUERY_STRING.toLowerCase()));
        }
    }

    @AfterSuite
    public void closeDriver() {
        query.close();
    }
}
