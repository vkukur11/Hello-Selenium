import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.ru/");
        WebElement queryString = driver.findElement(By.name("q"));
        queryString.sendKeys("Java");
        WebElement queryButton = driver.findElement(By.name("btnK"));
        queryButton.submit();


        //Close the browser
//        driver.quit();
    }
}
