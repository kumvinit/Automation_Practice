import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Actions a=new Actions(driver);
        WebElement move=driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));

        //using shift keyword enter text in caps and select it by double tapping
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //context/right click on sign in
        a.moveToElement(move).contextClick().build().perform();

        //Move to specific element - hover over
        a.moveToElement(driver.findElement(By.cssSelector("move']"))).build().perform();
    }
}
