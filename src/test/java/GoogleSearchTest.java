import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class GoogleSearchTest {
    private static final String QUERY_STRING = "Java";

    private Query query;

    @BeforeClass
    public void setUp() {
        query = new Query();
        query.openGoogle();
    }

    @Test
    private void isPageChangedTest() {
        String pageBeforeQuery = query.getPage();
        query.search(QUERY_STRING);
        String pageAfterQuery = query.getPage();
        assertNotEquals(pageBeforeQuery, pageAfterQuery);
    }

    @Test(dependsOnMethods = "isPageChangedTest")
    private void isIncludeEachResultQueryWord() {
        List<WebElement> queryH3Results = query.getAllResults();
        for (WebElement queryH3Result: queryH3Results) {
            assertTrue(queryH3Result.getText().toLowerCase().contains(QUERY_STRING.toLowerCase()));
        }
    }

    @AfterClass
    public void closeDriver() {
        query.close();
    }
}
