import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeSuite
    public void doQuery() {
        driver = new ChromeDriver();
        driver.get("https://www.google.ru/");
        WebElement queryString = driver.findElement(By.name("q"));
        queryString.sendKeys("Java");



        WebElement queryButton = driver.findElement(By.name("btnK"));
        queryButton.submit();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("r")));
    }

    @Test
    private void isIncludeEachResultQueryWord() {
        List<WebElement> queryResults = driver.findElements(By.className("r"));
        for (WebElement result: queryResults) {
            //Subresults also marked as "r" class
            if(result.getTagName().equals("h3")) {
                continue;
            }
            String resultText = result.findElement(By.tagName("h3")).getText();
            assertTrue(resultText.toLowerCase().contains("java"));
        }
    }

    @AfterSuite
    public void closeDriver() {
        driver.close();
    }
}
