/*
package setup;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Logs {
    public static IOSDriver<IOSElement> driver;

    static DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);

        //driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        //dc.setCapability("deviceName","iPhone");
        System.out.println(driver.isAppInstalled("com.klm.mobile.iphone.MCAR-iPhone"));
        //driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\")");

        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\",true,true)");


       // dc.setCapability(IOSMobileCapabilityType.PLATFORM,"iOS");
        //dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
        */
/*dc.setCapability(IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB,true);
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
        dc.setCapability(IOSMobileCapabilityType.NATIVE_INSTRUMENTS_LIB, true);*//*


        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);



    }
    */
/*public static void main(String args[]){
       *//*
*/
/* String s= String.valueOf(driver.manage().logs().getAvailableLogTypes());
        driver.manage().logs();*//*
*/
/*
        //driver.setLogLevel(Level.ALL);
        driver.executeScript("experitest:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@id='video_view']\", 0, \"view.pause(); var length = view.getDuration(); length = length*0.9; view.seekTo(length);\");");

        //System.out.println("Logs are:"+s);

    }*//*

    @Test
    public void test() throws InterruptedException {
        //driver.executeScript("experitest:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@id='video_view']\", 0, \"view.pause(); var length = view.getDuration(); length = length*0.9; view.seekTo(length);\");");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@accessibilityIdentifier='iconAddABooking']")).click();



    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
*/
package setup;
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected IOSDriver<IOSElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    @Test
    public void testUntitled() throws InterruptedException {
        //driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\"),true,true");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\",true,true)");
        Thread.sleep(2000);
       // driver.executeScript("experitest:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@id='video_view']\", 0, \"view.pause(); var length = view.getDuration(); length = length*0.9; view.seekTo(length);\");");
        //driver.findElement(By.xpath("//*[@accessibilityIdentifier='iconAddABooking']")).click();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        System.out.println("Before clicking the login button"+dateFormat.format(date)); //2016/11/16 12:08:43
        driver.findElementByXPath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Contact']]").click();
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}