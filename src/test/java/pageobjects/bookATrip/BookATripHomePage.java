package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookATripHomePage {
    IOSDriver driver;
    public BookATripHomePage(IOSDriver driver){
        this.driver=driver;

    }
    By origin = By.xpath("//*[@accessibilityIdentifier='Origin' and @top='true']");
    By destination = By.xpath("//*[@accessibilityIdentifier='Destination' and @top='true']");
    By travelParty = By.xpath("//*[contains(text(),'Class')]");
    By selectTravelDates = By.xpath("//*[@text='Select travel dates']");
    By whereFrom=By.xpath("//*[@accessibilityLabel='where from?']");
    By whereTo = By.xpath("//*[@accessibilityLabel='where to?']");
    By originSearchResult=By.xpath("//*[@text='Amsterdam']");
    By destinationSearchResult=By.xpath("//*[@text='Bahrain']");
    By confirmDates = By.xpath("//*[@text='Confirm dates']");
    By availableFlights = By.xpath("(//*[@class='UIATable']/*[@class='UIAView' and ./*[@class='UIAStaticText']])");
    By lightBrandedFare=By.xpath("//*[@text='Light']");
    By selectBrandedFareButton = By.xpath("//*[@text='Select']");
    public List<WebElement> availableFlights(){
        return driver.findElements(availableFlights);
    }
    public WebElement selectedFlight(int number){
        return availableFlights().get(number);

    }
    public By lightBrandedFare(){
        return lightBrandedFare;
    }


    //int date = 6;
    public WebElement selectlightBrandedFare(){
        return driver.findElement(lightBrandedFare);
    }

    public WebElement selectBrandedFareButton(){
        return driver.findElement(selectBrandedFareButton);
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
    public WebElement departureDate(int date){
        String oldDate = "(//*[@class='UIACollectionView']/*/*/*[@text='date'])[1]";
        String newDate = oldDate.replace("date",Integer.toString(date));
        By departureDate = By.xpath(newDate);
        return driver.findElement(departureDate);
    }
    public WebElement returnDate(int date){
        String oldDate = "(//*[@class='UIACollectionView']/*/*/*[@text='date'])[1]";
        String newDate = oldDate.replace("date",Integer.toString(date));
        By returnDate = By.xpath(newDate);
        return driver.findElement(returnDate);
    }
    //Returns ConfirmDates button
    public WebElement confirmDatesButton(){
        return driver.findElement(confirmDates);
    }





}
