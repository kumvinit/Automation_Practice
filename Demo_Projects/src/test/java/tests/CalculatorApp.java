package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

import static org.testng.Assert.fail;

public class CalculatorApp {
    private AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void setup(){
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
            caps.setCapability(MobileCapabilityType.UDID, "RZCT30F4HXV");
            //caps.setCapability("ignoreHiddenApiPolicyError", true);
            caps.setCapability("appPackage", "com.innovit.scientificcalculator");
            caps.setCapability("appActivity", "com.innovit.scientificcalculator.MainActivity");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver=new AndroidDriver<>(url, caps);
            System.out.println("Driver is" + driver.toString());
    }catch(Exception exp){
        System.out.println("cause is " +exp.getCause());
        System.out.println("Message is " +exp.getMessage());
        exp.getStackTrace(); //collecting the trace
        }
    }
    @Test
    public void SampleTest() throws InterruptedException {
        WebElement three =driver.findElement(By.id("com.innovit.scientificcalculator:id/number3Button"));//button 3
        WebElement five =driver.findElement(By.id("com.innovit.scientificcalculator:id/number5Button"));//button 5
        WebElement plus =driver.findElement(By.id("com.innovit.scientificcalculator:id/plusButton"));//button +
        WebElement seven =driver.findElement(By.id("com.innovit.scientificcalculator:id/number7Button")); //button7
        WebElement equalTo =driver.findElement(By.id("com.innovit.scientificcalculator:id/equalButton")); //Button =

        System.out.println("I am inside sample Test");

        three.click();
        plus.click();
        seven.click();
        equalTo.click();

        Thread.sleep(2000);
        String result =driver.findElement(By.id("com.innovit.scientificcalculator:id/displayResult")).getText();
        if (result.equals("=10")){
            System.out.println("Test is passed");
        }else {
            System.out.println("Test Failed");
            fail();
        }
    }
    @AfterTest
    public void teardown(){
        driver.closeApp();
        driver.quit();
    }
}
