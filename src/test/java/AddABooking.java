/*
//package <set your test package>;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.LoginPage;
import pageobjects.Profile;
import setup.FlyingBlue;
import setup.Sample;
import setup.Setup;
import setup.Utilities;
import sun.rmi.runtime.Log;

import java.net.URL;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import pageobjects.LoginPage;

public class AddABooking extends Setup {
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";

   // private Sample sample;
    //private IOSDriver driver;
   // protected IOSDriver<IOSElement> driver = setUp();

   // DesiredCapabilities dc = new DesiredCapabilities();
    //LoginPage loginPage=new LoginPage();


    public AddABooking() throws MalformedURLException {
    }

    */
/*  @Before
      public void setUp() throws MalformedURLException {
          dc.setCapability("reportDirectory", reportDirectory);
          dc.setCapability("reportFormat", reportFormat);
          dc.setCapability("testName", testName);
          dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
          dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
          driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
          driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
      }
  *//*

    */
/*@Test
    public void testUntitled() {
        driver.executeScript("client:client.setDevice(\"ios_app:IMO's iPhone 5S Pavan\")");
       // driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\")");
//        driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")));
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        loginPage.getFlyingBlue().click();
       *//*
*/
/* LoginPage.getFlyingBlue().click();
        LoginPage.getLogin().click();
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("1121711790");
        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']")).clear();
       // driver.getKeyboard().sendKeys("1121711790");
        LoginPage.getPassword().click();
        LoginPage.getPassword().sendKeys("1234");

        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']")).click();
        //driver.getKeyboard().sendKeys("1234");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before clicking the button"+dateFormat.format(date)); //2016/11/16 12:08:43
        LoginPage.getLoginButton().click();
        //driver.findElement(By.xpath("//*[@class='UIAButton' and ./preceding-sibling::*[@text='Log in'] and ./parent::*[@class='UIAView']]")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='1121711790' and @XCElementType='XCUIElementTypeTextView']")));
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        System.out.println("Time taken for login"+diff);*//*
*/
/*
       *//*
*/
/* driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Profile']]")).click();
        driver.findElement(By.xpath("//*[@class='UIAButton']")).click();
        driver.findElement(By.xpath("//*[@text='Log out' and @class='UIAButton']")).click();
        String text=driver.findElement(By.xpath("//*[@class='UIAButton']")).getText();
        System.out.println("Text of button is"+text);*//*
*/
/*



    }*//*

    @Test
    public void first() throws MalformedURLException {
        FlyingBlue flyingBlue = new FlyingBlue(driver);
        LoginPage loginPage = new LoginPage(driver);
        Profile profile=new Profile(driver);
        flyingBlue.flyingBlue().click();
//        Utilities.waitForElement(driver,loginPage.username());

        loginPage.login().click();
        loginPage.username().clear();
        loginPage.username().sendKeys("1121711790");
        loginPage.password().sendKeys("1234");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before clicking the button"+dateFormat.format(date)); //2016/11/16 12:08:43
        loginPage.loginButton().click();

        Utilities.waitForElement(driver,flyingBlue.getFlyingBlueNumberText());

//        flyingBlue.flyingBlueNumberText().click();
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        String value = Utilities.timeFormatter(diff);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for login"+value);
        profile.profileButton().click();
        profile.logoutButton().click();
        Date date2 = new Date();
        System.out.println("Before clicking logout button"+dateFormat.format(date));
        profile.alertTextLogout().click();
        Utilities.waitForElement(driver,profile.loginButtonText());
        Date date3 = new Date();
        System.out.println("After logout"+dateFormat.format(date));

        long diff1 = date3.getTime()-date2.getTime();
        String value1 = Utilities.timeFormatter(diff1);
        System.out.println("Time in Seconds"+diff1);
        System.out.println("Time taken for login"+value1);










    }



}*/
