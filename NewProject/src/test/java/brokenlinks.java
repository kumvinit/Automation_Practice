import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
public class brokenlinks {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,5000)");
        /*broken URL
Step 1 - IS to get all urls tied up to the links using Selenium
  Java methods will call URLs and get you the status code
if status code >400 then that url is not working-> link which tied to url is broken*/

        String url = driver.findElement(By.cssSelector("/a[href*=\'brokenlink\']")).getAttribute("href");
        HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int respCode = conn.getResponseCode();
        System.out.println(respCode);
    }
}
