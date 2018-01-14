package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookATripPage {
    IOSDriver driver;
    public BookATripPage(IOSDriver driver){
        this.driver=driver;

    }
    By origin = By.xpath("//*[@accessibilityLabel='Origin' and @XCElementType='XCUIElementTypeStaticText']");
    By destination = By.xpath("//*[@accessibilityLabel='Destination' and @XCElementType='XCUIElementTypeStaticText']");
    By travelParty = By.xpath("//*[@text='1 adult in Economy Class']");
    By selectTravelDates = By.xpath("//*[@text='Select travel dates']");
    By whereFrom=By.xpath("//*[@placeholder='where from?']");
    By whereTo = By.xpath("//*[@placeholder='where to?']");
    By originSearchResult=By.xpath("//*[@class='UIAView' and ./*[@text='Amsterdam']]");
    By destinationSearchResult=By.xpath("//*[@class='UIAView' and ./*[@text='Barcelona']]");
    By selectDepartureDateText = By.xpath("//*[@text='Select departure date']");

    int date = 6;
    String oldDate = "(//*[@class='UIACollectionView']/*/*/*[@text='date'])[1]";
    String newDate = oldDate.replace("date",Integer.toString(date));



    By departureDate = By.xpath(newDate);
    public By selectDepartureDateText(){
        return selectDepartureDateText;
    }

    public WebElement origin(){
        return driver.findElement(origin);
    }
    public WebElement destination(){
        return driver.findElement(destination);
    }
    public WebElement travelParty(){
        return driver.findElement(travelParty);
    }
    public WebElement selectTravelDates(){
        return driver.findElement(selectTravelDates);
    }
    public WebElement originSearchBar() {
        return driver.findElement(whereFrom);
    }
    public WebElement destinationSearchBar() {
        return driver.findElement(whereTo);
    }
    public WebElement originSearchResult(){
        return driver.findElement(originSearchResult);
    }
    public WebElement destinationSearchResult() {
        return driver.findElement(destinationSearchResult);
    }
    public WebElement departureDate(){
        return driver.findElement(departureDate);
    }

}
