package setup;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;

import Utilities.JUnitTestReporter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup extends JUnitTestReporter {
    public static IOSDriver<IOSElement> driver;

    static DesiredCapabilities dc = new DesiredCapabilities();


    @Before
    public void  setUp() throws MalformedURLException {

        dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
        //dc.setCapability(MobileCapabilityType.UDID, "d65cf8b56bc43982a82c36b879224df86d0e30a7");

        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);
        //dc.setCapability("instrumentApp", true);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        //driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"false\", \"true\")");
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);



    }
    @BeforeClass
    public static void startAppiumStudioServer() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("C:\\Users\\X085271\\Desktop\\appiumstudio.bat");
        Thread.sleep(30000);
    }
    public static IOSDriver initializeDriver() throws MalformedURLException {
        IOSDriver driver1;
        if(driver!=null){
            driver1= driver;
        }
        else{
            dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
            dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");

            driver1 = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);


        }
        return driver1;
    }
    @After
    public void teardown(){
        driver.quit();
    }

}
