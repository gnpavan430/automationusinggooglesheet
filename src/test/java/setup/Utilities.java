package setup;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
   static IOSDriver driver;
    public Utilities(){

    }
    public Utilities(IOSDriver driver){
        this.driver=driver;


    }
    By goodNetwork = By.xpath("//*[@text='Wifi' and @class='UIAView']");
    By edgeNetwork = By.xpath("//*[@text='Edge' and @class='UIAView']");

    public By getGoodNetwork() {
        return goodNetwork;
    }

    public By getEdgeNetwork() {
        return edgeNetwork;
    }

    public By getBadNetwork() {
        return badNetwork;
    }

    By badNetwork = By.xpath("//*[@text='Very Bad Network' and @class='UIAView']");

    public static void waitForElement(IOSDriver<IOSElement> driver, By element){
        new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(element));
       /* Date date=new Date();

        System.out.println("Time after waiting"+date);*/
        // new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element));






    }
    public int currentDate(){
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        System.out.println("Date is"+date);
        String dt=date.toString();

        int currentDate= Integer.parseInt(dt.substring(8,10));
        return currentDate;
    }
    public static long responseTime(String date){
        int hours = Integer.parseInt(date.substring(7,9));
        int minutes = Integer.parseInt(date.substring(10,12));
        int seconds= Integer.parseInt(date.substring(13,15));
        long timeInSeconds=(hours*3600)+(minutes*60)+seconds;
        return timeInSeconds;

    }

    public static double timeFormatter(Long time){
        double seconds=time/1000;
        System.out.println("seconds:"+seconds);
        double milliseconds=(double)(time%1000)/1000;
        System.out.println("Milli seconds:"+milliseconds);
        double duration=seconds+milliseconds;
        String value=""+seconds+"Seconds"+milliseconds+"Milli Seconds";
        return duration;


    }
    public void setBadNetworkCondition(IOSDriver driver){
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       /* String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }
       */ //driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 500, 2000, \"//*[@name='Developer' and @label='Developer' and @knownSuperClass='UIAccessibilityElement' and @enabled='true' and @hidden='false' and @onScreen='true']\", 1000, 7, true)");
        // System.out.println("text is"+driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").getText());
        //driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        // driver.findElementByXPath("//*[@class='UIASwitch']").click();
        // driver.findElement(By.xpath("//*[@class='UIASwitch']")).click();
        driver.findElementByXPath("//*[@text='Very Bad Network' and @class='UIAView']").click();
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");


        //driver.findElementByXPath("//*[@text='Edge' and @class='UIAView']").click();

    }
    public static void swipeWhileNotFound(By element){
        //driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, element, 1000, 5, true)");
        String elementToFind="//*[@accessibilityIdentifier='flight_Number_textview' and @text='KL1133  |' and @visible='true']";
        driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"NATIVE\", \"xpath=//*[@accessibilityIdentifier='flight_Number_textview' and @text='KL1133  |' and @visible='true']\", 0, 1000, 5, true)");


    }
    public static void swipe(){
        driver.executeScript("client:client.swipe(\"Down\", 400, 500)");

    }
    public boolean checkElementVisibility( By xpath) {
        try {
            driver.findElement(xpath);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    public static void captureScreenshot( WebDriver driver,String screenshotName)
    {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));

            System.out.println("Screenshot taken");
        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
    public void setEdgeNetwork(IOSDriver driver){
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
       /* String str1 = (String)driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }
       */ driver.findElementByXPath("//*[@text='Edge' and @class='UIAView']").click();
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");

    }
    public Date date(){
        Date date = new Date();
        return date;
    }


    public void setWifi(IOSDriver<IOSElement> driver) throws InterruptedException {
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
        Thread.sleep(4000);
       /*driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"//*[@value='Developer' and @XCElementType='XCUIElementTypeCell' and @onScreen='true']\", 1000, 8, true)");
        driver.findElementByXPath("//*[@text='Status' and @class='UIAView']").click();
        String i=driver.findElementByXPath("//*[@class='UIASwitch']").getAttribute("value");
        if(i.equalsIgnoreCase("0")){
            driver.findElementByXPath("//*[@class='UIASwitch']").click();
        }*/
        driver.findElementByXPath("//*[@text='Wifi' and @class='UIAView']").click();
        /*driver.findElementByXPath("(//*[@text='Network Link Conditioner']/*[@text='Back'])[1]").click();
        driver.findElementByXPath("//*[@text='Settings' and @class='UIAButton']").click();*/
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.getKeyboard().sendKeys("\"{HOME}\"");
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");

    }
    public void setNetwork(IOSDriver<IOSElement>driver, By networkType){
        driver.executeScript("client:client.launch(\"com.apple.Preferences\", \"true\", \"true\")");
        int size=driver.findElementsByXPath("//*[@text='Settings' and @class='UIAStaticText']").size();

            if(size>0){

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




        driver.findElement(networkType).click();
        driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\", \"true\", \"true\")");

    }
    public boolean isElementDisplayed(){
        try{
             driver.findElementByXPath("//*[@text='Settings' and @class='UIAStaticText']");
             return true;
        }
        catch (ElementNotFoundException e){
            System.out.println("Element not found");
            return false;
        }
    }
}
