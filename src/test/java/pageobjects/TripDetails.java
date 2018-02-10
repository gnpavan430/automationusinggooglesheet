package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TripDetails {
    IOSDriver driver;
    public TripDetails(IOSDriver driver){
        this.driver=driver;
    }
    By addToCalendarButton = By.xpath("//*[@accessibilityIdentifier='ic_s_add_calendar' and @parentHidden='true']");
    public WebElement addToCalendarButton(){
        return driver.findElement(addToCalendarButton);
    }
    public By getAddToCalendarButton(){
        return addToCalendarButton;
    }
}
