package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentConfirmationPage {
    IOSDriver driver;
    public PaymentConfirmationPage(IOSDriver driver){
        this.driver=driver;

    }
    By doneButton= By.xpath("//*[@text='Done']");
    By bookingCode = By.xpath("//*[contains(text(),'Booking code:')]" );
    By viewYourBooking = By.xpath("//*[@text='View your booking' and @visible='true']");
    By sharePaymentDetails = By.xpath("//*[@text='Share Payment Details' and @visible='true']");
    By addToCalendar = By.xpath("//*[@text='Add to Calendar' and @visible='true']");
    By paymentConfirmationTitleText = By.xpath("//*[@text='Payment confirmation' and @visible='true']");
    public By viewYourBookingBy(){
        return viewYourBooking;
    }
    public By sharePaymentDetailsBy(){
        return sharePaymentDetails;
    }
    public By addToCalendarBy(){
        return addToCalendar;
    }
    public By paymentConfirmationTitleTextBy(){
        return paymentConfirmationTitleText;
    }
    public WebElement viewYourBooking(){
        return driver.findElement(viewYourBooking);
    }
    public WebElement sharePaymentDetails(){
        return driver.findElement(sharePaymentDetails);
    }
    public WebElement addToCalendar(){
        return driver.findElement(addToCalendar);
    }
    public WebElement paymentConfirmationTitleText(){
        return driver.findElement(paymentConfirmationTitleText);
    }


}
