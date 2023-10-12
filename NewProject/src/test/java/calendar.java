import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class calendar {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companion/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0, 1000)");

        //Pick 14th April date
        driver.findElement(By.id("form-field-travel_comp_date")).click();
        driver.findElements(By.cssSelector("span[class='flatpickr-day ']"));

        //Select the month first
        while(!driver.findElement(By.cssSelector(".cur-month")).getText().contains("April"))
        {
            driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
            Thread.sleep(1000);
        }

        //Select date now
        int count = driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).size();
        System.out.println(count);
        for (int i=0; i<count; i++){
            String text = driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).get(i).getText();
            System.out.println(text);

            if (text.equalsIgnoreCase("16")){
                driver.findElements(By.cssSelector("span[class='flatpickr-day ']")).get(i).click();
                break;
            }
        }
    }
}
