import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class javaScriptExecution {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js= (JavascriptExecutor)driver; //driver would know that it can execute JS
        //1. Scrolling window using JS action
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(3000);

        //2. Scrolling table using JS DOM action
        js.executeScript("document.querySelector(\'.tableFixHead\').scrollTop=5000");
        List<WebElement> values = driver.findElements(By.cssSelector("div[class='tableFixHead'] td:nth-child(4)"));
        //3. Sum the numbers in table

        int sum=0;
        for (int i=0; i<values.size(); i++){
            Integer.parseInt(values.get(i).getText()); //parsing string into integer

            sum= sum + Integer.parseInt(values.get(i).getText());

        }
        System.out.println(sum);
        //4. Verify the Sum amount with the text written below the table
        String text = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
        int total=Integer.parseInt(text);

        Assert.assertEquals(sum, total); //comparing the website String with the sum


    }
}
