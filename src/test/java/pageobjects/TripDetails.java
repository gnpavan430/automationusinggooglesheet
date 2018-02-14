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
    public By flightNumberElement(String flightNumber){
        String flightNumberLocator = "(//*[@class='UIACollectionView']/*/*/*[@text='flightNumber'])[1]";
        String newFlightNumberLocator = flightNumberLocator.replace("flightNumber",flightNumber);
        //String newDate = oldDate.replace("date",Integer.toString(date));
        By flightNumberElement = By.xpath(newFlightNumberLocator);
        return flightNumberElement;
    }

    public WebElement addToCalendarButton(){
        return driver.findElement(addToCalendarButton);
    }
    public By getAddToCalendarButton(){
        return addToCalendarButton;
    }
}
