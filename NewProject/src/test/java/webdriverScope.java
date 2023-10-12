import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class webdriverScope {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //1. Find the number of links available on the webpage
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. Find the number of links available only in the footer section - Create mini driver
        //Limiting webdriver scope
        WebElement footerdriver= driver.findElement(By.id("gf-BIG"));
        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3. Find the no of links only in the first column
        WebElement coloumnDriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(coloumnDriver.findElements(By.tagName("a")).size());

        //4. Click on each link in the column and check if pages are opening
        for (int i=1; i<coloumnDriver.findElements(By.tagName("a")).size(); i++) {

            String clickonlinks = Keys.chord(Keys.COMMAND, Keys.ENTER);
            coloumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinks);
            Thread.sleep(5000);
        }
            //5. Get the Title of the pages as well
            Set<String> abc = driver.getWindowHandles();
            Iterator<String> it = abc.iterator();

            while (it.hasNext()){                  //hasNext checks if we have next window present or not
                driver.switchTo().window(it.next());              //next actually moves the control to next window
                System.out.println(driver.getTitle());
            }

    }
}
