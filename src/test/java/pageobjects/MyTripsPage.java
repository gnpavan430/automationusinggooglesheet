package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTripsPage {
    IOSDriver driver;
    public MyTripsPage(IOSDriver driver){
        this.driver=driver;
    }
    By addABooking = By.xpath("//*[@accessibilityLabel='Add a booking' and @top='true']");
    By title = By.xpath("//*[@text='My trips' and ./parent::*[@class='CoreAppRedesign.CustomNavigationBar']]");

    By addABookingActionButton = By.xpath("//*[@accessibilityIdentifier='iconAddABooking']");
    By myTripCardButton = By.xpath("//*[@accessibilityIdentifier='ic_s_arrow' and @top='true']");
    String newBookingCode;
    By bookingCodeText;
    public By myTripTitle(){
        return title;

    }

    public void setBookingCode(String booking){
        String bookingCode="//*[@text='Booking code RFQO8G']";
         newBookingCode=bookingCode.replace("RFQO8G",booking);
         bookingCodeText=By.xpath(newBookingCode);

    }
    public WebElement myTripFlightStatus(String displayStatus){
        String xpath = "//*[@text='flightStatus' and @top='true']";
        String newXpath=xpath.replace("flightStatus",displayStatus);
        return driver.findElementByXPath(newXpath);
    }
    public WebElement flightStatusMyTrips(){
        List<WebElement> flightStatusMyTripsElement= driver.findElements(flightStatusMyTrips);
        return flightStatusMyTripsElement.get(1);
    }
    public WebElement myTripsTitle(){
        return driver.findElement(title);
    }
    public By title(){
        return title;
    }
    public By flightStatusMyTrips = By.xpath("//*[@accessibilityIdentifier='flightstatusID' and @visible='true']");



    public By bookingCode(){
        return bookingCodeText;
    }
    public WebElement bookingCodeText(){
        return driver.findElement(bookingCodeText);
    }
    public WebElement addABooking(){
        return driver.findElement(addABooking);
    }
    public WebElement addABookingActionButton(){
        return driver.findElement(addABookingActionButton);
    }
    public WebElement myTripCardButton(){
        return driver.findElement(myTripCardButton);
    }
}
