import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class Query {
    private WebDriver driver;

    public Query() {
        driver = new ChromeDriver();
    }

    public String getPage() {
        return driver.getPageSource();
    }

    public void openGoogle() {
        driver.get("https://www.google.ru/");
    }

    public void search(String query) {
        WebElement queryString = driver.findElement(By.name("q"));
        queryString.sendKeys(query);

        WebElement queryButton = driver.findElement(By.name("btnK"));
        queryButton.submit();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("r")));
    }

    public List<WebElement> getAllResults() {
        List<WebElement> results = driver.findElements(By.className("r"));

        Iterator<WebElement> i = results.iterator();
        while (i.hasNext()) {
            WebElement result = i.next();
            if(result.getTagName().equals("h3")) {
                i.remove();
            }
        }
        return results;
    }

    public void close() {
        driver.close();
    }
}