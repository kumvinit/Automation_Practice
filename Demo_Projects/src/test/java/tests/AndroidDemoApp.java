package tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static io.appium.java_client.touch.offset.PointOption.point;

public class AndroidDemoApp {
    private AndroidDriver<MobileElement> driver;
    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            caps.setCapability(MobileCapabilityType.UDID, "RZCT30F4HXV");
            //caps.setCapability("ignoreHiddenApiPolicyError", true);
            caps.setCapability("appPackage", "com.saucelabs.mydemoapp.rn");
            caps.setCapability("appActivity", "MainActivity");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver=new AndroidDriver<>(url, caps);
            System.out.println("Driver is" + driver.toString());
        }catch(Exception exp) {
            System.out.println("cause is " + exp.getCause());
            System.out.println("Message is " + exp.getMessage());
            exp.getStackTrace(); //collecting the trace
        }
    }
    @Test (priority = 1)
    public void SampleTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(@text,'Sauce Labs Backpack')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Add To Cart button\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Proceed To Checkout button\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]")).sendKeys("bob@example.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]")).sendKeys("10203040");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]")).click();
        Thread.sleep(2000);
    }
    @Test (priority = 2)
    public void Address_page() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Vinita Gupta");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")).sendKeys("8th cross road");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Address Line 2 input field\"]")).sendKeys("Kundalahalli");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]")).sendKeys("Bangalore");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"State/Region input field\"]")).sendKeys("Karnataka");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")).sendKeys("560066");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]")).sendKeys("India");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"To Payment button\"]")).click();
        Thread.sleep(2000);
    }
    @Test (priority = 3)
    public void checkOut() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Full Name* input field\"]")).sendKeys("Vinita Gupta");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]")).sendKeys("325812657568789");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")).sendKeys("0325");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]")).sendKeys("246");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Review Order button\"]/android.widget.TextView")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Place Order button\"]/android.widget.TextView")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Continue Shopping button\"]/android.widget.TextView")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void teardown(){
        driver.closeApp();
        driver.quit();
    }
}

