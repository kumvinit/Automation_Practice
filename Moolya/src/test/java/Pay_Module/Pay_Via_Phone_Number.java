package Pay_Module;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Pay_Via_Phone_Number {
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
            caps.setCapability("appPackage", "com.epifi.paisa.qa");
            caps.setCapability("appActivity", "com.epifi.paisa.ui.splash.SplashActivity");
            //caps.setCapability(MobileCapabilityType.APP, "/Users/vinitagupta/IdeaProjects/Moolya/apk/QaDebug-2263.apk");
            caps.setCapability(MobileCapabilityType.NO_RESET, "true"); //it prevents the app from re-installing each time
            caps.setCapability(MobileCapabilityType.FULL_RESET, "false");
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, caps);
        } catch (Exception exp) {
            System.out.println("cause is " + exp.getCause());
            System.out.println("Message is " + exp.getMessage());
            exp.getStackTrace(); //collecting the trace
        }

    }

    @Test  (priority =1)
    public void onboarding() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//*[contains(@text, 'Use PIN')]")).click();
        Thread.sleep(2000);
        adbInputText("1234");
        driver.findElement(By.xpath("//*[contains(@text, 'Continue')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.epifi.paisa.qa.home:id/btn_pay")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*/android.view.ViewGroup[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.epifi.paisa.qa:id/et_searchText")).sendKeys("9985281105");
        Thread.sleep(3000);
        driver.findElement(By.id("com.epifi.paisa.qa:id/user_info_view")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.epifi.paisa.qa.pay:id/button_pay")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("com.epifi.paisa.qa:id/et_money")).sendKeys("100");
        Thread.sleep(2000);
        driver.findElement(By.id("com.epifi.paisa.qa.pay:id/pay_button")).click();
        Thread.sleep(2000);
        System.out.println("Test 1 is passed");
    }
    @Test (priority =2)
    public void enterPIN() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//*[contains(@text,'1')]")).click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//android.widget.TableRow/android.widget.ImageView)[2]")).click();
        Thread.sleep(15000);
        System.out.println("Test 2 is passed");
    }
    @Test (priority = 3)
        public void lastStep() throws InterruptedException {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.epifi.paisa.qa:id/icon_navigation")).click();
        Thread.sleep(2000);
        System.out.println("Test 3 is passed");
    }

    private void adbInputText(String text) throws IOException, InterruptedException {
        Process proc = Runtime.getRuntime().exec("adb shell input text " + text); //This is for adb input
        proc.waitFor();
    }

    @AfterTest
    public void teardown() {
        driver.closeApp();
        driver.quit();
    }

}
