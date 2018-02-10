package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewAddABookingPage {
    IOSDriver driver;
    public NewAddABookingPage(IOSDriver driver){
        this.driver=driver;
    }
    By addABookingHeaderText= By.xpath("//*[@text='Add a booking' and @class='KLMCustomLabel']");
    By bookingCode = By.xpath("//*[@accessibilityLabel='Booking code or ticketnumber' and @top='true']");
    By lastName= By.xpath("//*[@accessibilityLabel='Last name' and @class='UITextFieldLabel']");
    By findYourBooking = By.xpath("((//*[@class='UITableViewWrapperView' and ./following-sibling::*[@class='UIView']]/*/*[@class='UITableViewCellContentView' and ./parent::*[@class='UITableViewCell']])[1]/*/*/*[@class='CoreAppRedesign.KLMAppButton' and ./following-sibling::*[@text='Find your booking']])[2]");
    By scanBoardingPass = By.xpath("((//*[@class='UITableViewWrapperView' and ./following-sibling::*[@class='UIView']]/*/*[@class='UITableViewCellContentView' and ./parent::*[@class='UITableViewCell']])[1]/*/*/*[@text='Scan boarding pass'])[2]");
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
