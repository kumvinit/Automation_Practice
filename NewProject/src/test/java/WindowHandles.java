import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;


public class WindowHandles {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
        driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
        //Switch from parent to child window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.cssSelector("p[class=\'im-para red\']")).getText());

        //Splitting the text from before-after at
        //The email resides in the array[1], trim the spaces from front and end
        String emailID = driver.findElement(By.cssSelector("p[class=\'im-para red\']")).getText()
                .split("at")[1].trim().split(" ")[0];

        //Switch from child to parent window
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(emailID);
    }
}
