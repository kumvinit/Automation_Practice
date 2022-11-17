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
        WebElement one =driver.findElement(By.id("com.innovit.scientificcalculator:id/number1Button"));//button 1
        WebElement two =driver.findElement(By.id("com.innovit.scientificcalculator:id/number2Button"));//button 2
        WebElement three =driver.findElement(By.id("com.innovit.scientificcalculator:id/number3Button"));//button 3
        WebElement four =driver.findElement(By.id("com.innovit.scientificcalculator:id/number4Button"));//button 4
        WebElement five =driver.findElement(By.id("com.innovit.scientificcalculator:id/number5Button"));//button 5
        WebElement six =driver.findElement(By.id("com.innovit.scientificcalculator:id/number6Button"));//button 6
        WebElement seven =driver.findElement(By.id("com.innovit.scientificcalculator:id/number7Button")); //button 7
        WebElement eight =driver.findElement(By.id("com.innovit.scientificcalculator:id/number8Button"));//button 8
        WebElement nine =driver.findElement(By.id("com.innovit.scientificcalculator:id/number9Button"));//button 9
        WebElement zero =driver.findElement(By.id("com.innovit.scientificcalculator:id/number9Button"));//button 0
        WebElement decimal =driver.findElement(By.id("com.innovit.scientificcalculator:id/decimalButton"));//button decimal
        WebElement Cancel =driver.findElement(By.id("com.innovit.scientificcalculator:id/acButton"));//button All Cancel
        WebElement backSpace =driver.findElement(By.id("com.innovit.scientificcalculator:id/backspaceButton"));//button BackSpace
        WebElement equalTo =driver.findElement(By.id("com.innovit.scientificcalculator:id/equalButton")); //Button =
        WebElement divide =driver.findElement(By.id("com.innovit.scientificcalculator:id/divideButton")); //Button divide
        WebElement multiply =driver.findElement(By.id("com.innovit.scientificcalculator:id/multiplyButton")); //Button x multiply
        WebElement plus =driver.findElement(By.id("com.innovit.scientificcalculator:id/plusButton"));//button +
        WebElement subtract =driver.findElement(By.id("com.innovit.scientificcalculator:id/subtractButton"));
        WebElement percentage =driver.findElement(By.id("com.innovit.scientificcalculator:id/percentButton"));

        System.out.println("I am inside sample Test");

        five.click();
        nine.click();
        plus.click();
        three.click();
        subtract.click();
        four.click();
        equalTo.click();

        Thread.sleep(2000);
        String result =driver.findElement(By.id("com.innovit.scientificcalculator:id/displayResult")).getText();
        if (result.equals("=58")){
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
