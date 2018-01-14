package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTripsPage {
    IOSDriver driver;
    public MyTripsPage(IOSDriver driver){
        this.driver=driver;
    }
    By addABooking = By.xpath("//*[@text='Add a booking']");
    By title = By.xpath("//*[@text='My trips' and ./parent::*[@class='UIANavigationBar']]");

    By addABookingActionButton = By.xpath("(//*[@text='MyTripsView']/*[@class='UIAButton'])[2]");
    String newBookingCode;
    By bookingCodeText;

    public void setBookingCode(String booking){
        String bookingCode="//*[@text='Booking code RFQO8G']";
         newBookingCode=bookingCode.replace("RFQO8G",booking);
         bookingCodeText=By.xpath(newBookingCode);

    }
    public WebElement myTripsTitle(){
        return driver.findElement(title);
    }
    public By title(){
        return title;
    }


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
}
