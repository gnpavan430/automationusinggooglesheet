package testcases;

/*import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageobjects.*;
import setup.GetLogs;
import setup.NewSetup;
import setup.Quickstart;
import setup.Utilities;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import Utilities.FileUtilities;

//import static org.junit.Assert.assertTrue;




public class FlightStatusTest extends NewSetup {
    String flightStatus,displayedStatus;
    ExtentReports extent;
    ExtentTest logger;
    //public static String previousFlightStatus="ONTIME";
   /* public FlightStatusTest(String flightStatus,String displayedStatus){
        this.flightStatus=flightStatus;
        this.displayedStatus=displayedStatus;

    }*/
    @BeforeTest
    public void startReport(){
        //ExtentReports(String filePath,Boolean replaceExisting)
        //filepath - path of the file, in .htm or .html format - path where your report needs to generate.
        //replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
        //True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
        //False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        extent = new ExtentReports (System.getProperty("user.dir") +"/ExtentReport/Report"+dateName+".html", true);
        //extent.addSystemInfo("Environment","Environment Name")
        extent
                .addSystemInfo("Host Name", "SoftwareTestingMaterial")
                .addSystemInfo("Environment", "Automation Testing");
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }

    //@Parameters({ "EARLY_ARRIVAL","EARLY Arrival" }, {"DELAYED_ARRIVAL","Delayed Arrival" }, { "EARLY_DEPARTURE","Early Departure"}, { "DELAYED_DEPARTURE","Delayed Departure" })
    @Test(dataProvider="data")
    public void flightStatusTest(String flightStatus,String displayedStatus) throws Exception {

        Quickstart quickstart = new Quickstart();
        HomePage homePage=new HomePage(driver);
        MyTripsPage myTripsPage=new MyTripsPage(driver);
        Utilities utilities = new Utilities(driver);
        TripDetails tripDetails = new TripDetails(driver);
        NewAddABookingPage addABookingPage = new NewAddABookingPage(driver);
        FileUtilities fileUtilities = new FileUtilities();
        String previousFlightStatus = fileUtilities.pubilshStatus();
        System.out.println("Previous flight from response is "+previousFlightStatus);
        //For the first time PreviousFlightStatus is taken as String variable. From next time onwards data is read from the file "Published Status"
        fileUtilities.flightStatusChange(previousFlightStatus,flightStatus);
        Thread.sleep(2000);

        logger = extent.startTest("Test case Name"+flightStatus);
        //GetLogs getLogs=new GetLogs();

        homePage.myTrips().click();
        logger.log(LogStatus.PASS, "Navigated to My Trips Page");
        String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
        logger.log(LogStatus.PASS, logger.addScreenCapture(screenshotPath));

        Thread.sleep(4000);
        //driver.executeScript("client:client.swipe(\"Down\", 400, 500)");

        if(isElementPresent(By.xpath("//*[@accessibilityLabel='Add a booking' and @top='true']"))){
            System.out.println("inside if");
            myTripsPage.addABooking().click();
            logger.log(LogStatus.PASS, "Navigated to Add Booking Page");
            //String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
            logger.log(LogStatus.PASS, logger.addScreenCapture(FlightStatusTest.getScreenshot(driver,"Add Booking Page")));
        }
        else if(myTripsPage.addABookingActionButton().isDisplayed()){
            myTripsPage.addABookingActionButton().click();
            logger.log(LogStatus.PASS, "Navigated to Add Booking Page");
            //String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
            logger.log(LogStatus.PASS, logger.addScreenCapture(FlightStatusTest.getScreenshot(driver,"Add Booking Page")));
        }
        Thread.sleep(8000);
        addABookingPage.bookingCode().click();
        //addABookingPage.bookingCode().sendKeys("KXAKXW");
        driver.getKeyboard().sendKeys("WP3PIU");

        Thread.sleep(4000);
        addABookingPage.lastName().click();
        driver.getKeyboard().sendKeys("LAST");

        //addABookingPage.lastName().sendKeys("LOU");
        myTripsPage.setBookingCode("WP3PIU");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //getLogs.startLogs();

        addABookingPage.findYourBookingButton().click();
        Date date = new Date();
        System.out.println("Just after clicking the add a booking button"+dateFormat.format(date));
        Utilities.waitForElement(driver,myTripsPage.title());
        Date date1 = new Date();
        System.out.println("After adding booking date is"+date1);

        logger.log(LogStatus.PASS, "New Booking added to My Tips");
        //String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
        logger.log(LogStatus.PASS, logger.addScreenCapture(FlightStatusTest.getScreenshot(driver,"New Booking added to My Tips")));

        Utilities.waitForElement(driver,myTripsPage.bookingCode());
        //myTripsPage.bookingCodeText().click();
        myTripsPage.myTripCardButton().click();
//        String text = driver.findElementByXPath("//*[@text='Mon 05 Feb' and ./following-sibling::*[@text='10:20']]").getText();
        //System.out.println("Extracted text is"+text);
        Utilities.waitForElement(driver,tripDetails.getAddToCalendarButton());

        logger.log(LogStatus.PASS, "Navigated to Flight Strip Page");
        //String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
        logger.log(LogStatus.PASS, logger.addScreenCapture(FlightStatusTest.getScreenshot(driver,"Navigated to Flight Strip Page")));

        //Utilities.swipeWhileNotFound(tripDetails.flightNumberElement("KL1681"));
        String flightStatusText= driver.findElementByXPath("//*[@accessibilityIdentifier='flight_status_label' and @hidden='false' and @onScreen='true' and @visible='true' and @top='true']").getText();
        System.out.println("Extracted text is"+flightStatus);
        previousFlightStatus=fileUtilities.pubilshStatus();
        System.out.println("PublishedStatus is"+previousFlightStatus);
        System.out.println("Flight status in app is"+flightStatusText);
        //assertTrue(flightStatus.equalsIgnoreCase(displayedStatus));
        Assert.assertEquals(flightStatusText,displayedStatus);
        logger.log(LogStatus.PASS, "Flight Status Updated Correctly:"+displayedStatus);
        //String screenshotPath = FlightStatusTest.getScreenshot(driver,"My Trips Page");
        logger.log(LogStatus.PASS, logger.addScreenCapture(FlightStatusTest.getScreenshot(driver,"Flight Status Updated Correctly")));
    }
   /* @Parameterized.Parameters
    public static List<Object> data1() throws IOException {
        //Quickstart quickstart = new Quickstart();
        String[] values = new String[]{"EARLY_ARRIVAL","DELAYED_ARRIVAL","EARLY_DEPARTURE","DELAYED_DEPARTURE"};
        System.out.println("Values from sheet are"+values);
        List<Object> list = new ArrayList<Object>();
        for(int i=0;i<values.length;i++){
            list.add(values);
        }

        //List<Object> list = values.get(0);
        System.out.println("Values in list are"+list);
        return list;

    }*/
    //List of flight status that needs to be verified

    @DataProvider(name = "data")
    public static Object[][] data() {
        return new Object[][]{
                { "EARLY_ARRIVAL","Early arrival" }, {"DELAYED_ARRIVAL","Delayed arrival" }, { "EARLY_DEPARTURE","Early departure"}, { "DELAYED_DEPARTURE","Delayed departure" }

        };
        //return Arrays.asList(new Object[][] {{ "EARLY_ARRIVAL","EARLY Arrival" }, {"DELAYED_ARRIVAL","Delayed Arrival" }, { "EARLY_DEPARTURE","Early Departure"}, { "DELAYED_DEPARTURE","Delayed Departure" }});
    }

    public static String getScreenshot(IOSDriver driver, String screenshotName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    protected boolean isElementPresent(By by) {
        boolean isElement = false;
        try
        {
            if (driver.findElement(by) != null)
            {
                isElement = true;
                return isElement;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Element not found");
            isElement = false;
            return isElement;
        }
        return isElement;
    }
    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            // logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
            logger.log(LogStatus.FAIL, "Test Case Failed for status "+displayedStatus);
            String screenshotPath = FlightStatusTest.getScreenshot(driver, result.getName());
            //To add it in the extent report
            logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
        }else if(result.getStatus() == ITestResult.SKIP){
            logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        // ending test
        //endTest(logger) : It ends the current test and prepares to create HTML report
        extent.endTest(logger);
    }
    @AfterTest
    public void endReport(){
        // writing everything to document
        //flush() - to write or update test information to your report.
        extent.flush();
        //Call close() at the very end of your session to clear all resources.
        //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
        //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream.
        //Once this method is called, calling any Extent method will throw an error.
        //close() - To close all the operation
        extent.close();
    }
}
