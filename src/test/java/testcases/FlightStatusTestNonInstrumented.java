package testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import pageobjects.HomePage;
import pageobjects.MyTripsPage;
import pageobjects.NewAddABookingPage;
import setup.GetLogs;
import setup.Quickstart;
import setup.Setup;
import setup.Utilities;

public class FlightStatusTestNonInstrumented extends Setup {
    @Test
    public void flightStatus() throws InterruptedException {
        Quickstart quickstart = new Quickstart();
        HomePage homePage=new HomePage(driver);
        MyTripsPage myTripsPage=new MyTripsPage(driver);
        Utilities utilities = new Utilities(driver);
        NewAddABookingPage addABookingPage = new NewAddABookingPage(driver);
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
        addABookingPage.bookingCode().sendKeys("RB56V9");
        addABookingPage.lastName().sendKeys("LIM");
        myTripsPage.setBookingCode("RB56V9");
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
