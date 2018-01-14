package testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import pageobjects.AddABookingPage;
import pageobjects.HomePage;
import pageobjects.MyTripsPage;
import setup.GetLogs;
import setup.Setup;
import setup.Utilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AddABookingTest extends Setup {
    public static ArrayList<String> data=new ArrayList<>();
    @Test
    public void addABookingTest() throws InterruptedException, IOException {
        HomePage homePage=new HomePage(driver);
        MyTripsPage myTripsPage=new MyTripsPage(driver);
        Utilities utilities = new Utilities(driver);
        AddABookingPage addABookingPage = new AddABookingPage(driver);
        GetLogs getLogs=new GetLogs();
        homePage.myTrips().click();
        Thread.sleep(4000);
        driver.executeScript("client:client.swipe(\"Down\", 400, 500)");

        if(isElementPresent(By.xpath("//*[@text='Add a booking']"))){
            System.out.println("inside if");
            myTripsPage.addABooking().click();
        }
        else if(myTripsPage.addABookingActionButton().isDisplayed()){
            myTripsPage.addABookingActionButton().click();
        }
        addABookingPage.bookingCode().sendKeys("RFQO8G ");
        addABookingPage.lastName().sendKeys("QUINTAES");
        myTripsPage.setBookingCode("RFQO8G");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        getLogs.startLogs();
        Date date = new Date();
        System.out.println("Before clicking the add a booking button"+dateFormat.format(date));
        addABookingPage.findYourBookingButton().click();
        Utilities.waitForElement(driver,myTripsPage.title());
        Date date1 = new Date();
        System.out.println("After adding booking date is"+date1);
        Utilities.waitForElement(driver,myTripsPage.bookingCode());

        System.out.println("After booking is added"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        long value= TimeUnit.MILLISECONDS.toSeconds(diff);
        //double value = Utilities.timeFormatter(diff);
        getLogs.stopLogs();
        data=getLogs.readData();
        System.out.println("Data is"+data);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for adding a booking"+value);


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
