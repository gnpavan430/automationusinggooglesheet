package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddABookingPage {
    IOSDriver driver;
    public AddABookingPage(IOSDriver driver){
        this.driver=driver;
    }
    By addABookingHeaderText= By.xpath("//*[@text='Add a booking']");
    By bookingCode = By.xpath("//*[@placeholder='Booking code or ticketnumber']");
    By lastName= By.xpath("//*[@placeholder='Last name']");
    By findYourBooking = By.xpath("((//*[@class='UIATable']/*[@class='UIAView'])[4]/*[@text='Find your booking'])[2]");
    By scanBoardingPass = By.xpath("((//*[@class='UIATable']/*[@class='UIAView'])[4]/*[@text='Scan boarding pass'])[2]");
    public WebElement bookingCode(){
        return driver.findElement(bookingCode);
    }
    public WebElement lastName(){
        return driver.findElement(lastName);
    }
    public WebElement findYourBookingButton(){
        return driver.findElement(findYourBooking);
    }

}
