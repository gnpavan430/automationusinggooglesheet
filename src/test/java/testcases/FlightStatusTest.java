package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageobjects.*;
import setup.GetLogs;
import setup.NewSetup;
import setup.Quickstart;
import setup.Utilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import Utilities.FileUtilities;

import static org.junit.Assert.assertTrue;
@RunWith(Parameterized.class)
public class FlightStatusTest extends NewSetup {
    String flightStatus,displayedStatus;
    public static String previousFlightStatus="INTRANSIT";
    public FlightStatusTest(String flightStatus,String displayedStatus){
        this.flightStatus=flightStatus;
        this.displayedStatus=displayedStatus;
    }
    @Test
    public void flightStatusTest() throws InterruptedException, IOException {
        Quickstart quickstart = new Quickstart();
        HomePage homePage=new HomePage(driver);
        MyTripsPage myTripsPage=new MyTripsPage(driver);
        Utilities utilities = new Utilities(driver);
        TripDetails tripDetails = new TripDetails(driver);
        NewAddABookingPage addABookingPage = new NewAddABookingPage(driver);
        FileUtilities fileUtilities = new FileUtilities();
        System.out.println("Previous flight from response is "+previousFlightStatus);
        fileUtilities.flightStatusChange(previousFlightStatus,flightStatus);

        //GetLogs getLogs=new GetLogs();
        homePage.myTrips().click();
        Thread.sleep(4000);
        //driver.executeScript("client:client.swipe(\"Down\", 400, 500)");

        if(isElementPresent(By.xpath("//*[@accessibilityLabel='Add a booking' and @top='true']"))){
            System.out.println("inside if");
            myTripsPage.addABooking().click();
        }
        else if(myTripsPage.addABookingActionButton().isDisplayed()){
            myTripsPage.addABookingActionButton().click();
        }
        Thread.sleep(8000);
        addABookingPage.bookingCode().click();
        //addABookingPage.bookingCode().sendKeys("KXAKXW");
        driver.getKeyboard().sendKeys("PTC5XR");

        Thread.sleep(4000);
        addABookingPage.lastName().click();
        driver.getKeyboard().sendKeys("EVERWIJN");

        //addABookingPage.lastName().sendKeys("LOU");
        myTripsPage.setBookingCode("PTC5XR");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //getLogs.startLogs();

        addABookingPage.findYourBookingButton().click();
        Date date = new Date();
        System.out.println("Just after clicking the add a booking button"+dateFormat.format(date));
        Utilities.waitForElement(driver,myTripsPage.title());
        Date date1 = new Date();
        System.out.println("After adding booking date is"+date1);
        Utilities.waitForElement(driver,myTripsPage.bookingCode());
        //myTripsPage.bookingCodeText().click();
        myTripsPage.myTripCardButton().click();
//        String text = driver.findElementByXPath("//*[@text='Mon 05 Feb' and ./following-sibling::*[@text='10:20']]").getText();
        //System.out.println("Extracted text is"+text);
        Utilities.waitForElement(driver,tripDetails.getAddToCalendarButton());
        String flightStatus= driver.findElementByXPath("//*[@accessibilityIdentifier='flight_status_label' and @hidden='false' and @onScreen='true' and @visible='true' and @top='true']").getText();
        System.out.println("Extracted text is"+flightStatus);
        previousFlightStatus=fileUtilities.pubilshStatus();
        System.out.println("PublishedStatus is"+previousFlightStatus);
        assertTrue(flightStatus.equalsIgnoreCase(fileUtilities.pubilshStatus()));
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
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{ "EARLY_ARRIVAL","EARLY Arrival" }, {"DELAYED_ARRIVAL","Delayed Arrival" }, { "EARLY_DEPARTURE","Early Departure"}, { "DELAYED_DEPARTURE","Delayed Departure" }});
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
}
