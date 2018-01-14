package setup;


import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Settings {
    IOSDriver<IOSElement> driver;
    DesiredCapabilities dc = new DesiredCapabilities();

    @Test
    public void test() throws MalformedURLException {
        /*driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
        driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");

*/      dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);
        driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       // String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell\", 1000, 8, true)");
        for(int i=0;i<6;i++){
            driver.executeScript("client:client.swipe(\"Down\", 400, 2000)");

        }
        driver.findElement(By.xpath("//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']")).click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();

        }
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();




    }
}
