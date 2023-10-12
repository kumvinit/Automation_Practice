import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class framesTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        //To know how many frames in the webpage using tag
        System.out.println(driver.findElement(By.tagName("iframe")).getSize());

        //Switch to the frame view
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        driver.findElement(By.id("draggable")).click();
        Actions a=new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));

        //dra & drop action
        a.dragAndDrop(source, target).build().perform();

        //To switch back to the webpage
        driver.switchTo().defaultContent();
    }
}
