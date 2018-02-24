package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookATripPage {
    IOSDriver driver;
    public BookATripPage(IOSDriver driver){
        this.driver=driver;

    }
    //By origin = By.xpath("//*[@accessibilityLabel='Origin' and @XCElementType='XCUIElementTypeStaticText']");
    By origin = By.xpath("//*[@accessibilityIdentifier='Origin' and @top='true']");
    By destination = By.xpath("//*[@accessibilityIdentifier='Destination' and @top='true']");

    By travelParty = By.xpath("//*[@text='1 adult in Economy Class']");
    By selectTravelDates = By.xpath("//*[@text='Select travel dates']");
    By whereFrom=By.xpath("//*[@placeholder='where from?']");
    By whereTo = By.xpath("//*[@placeholder='where to?']");
    By originSearchResult=By.xpath("//*[@text='Amsterdam']");
    By destinationSearchResult=By.xpath("//*[@text='Bahrain']");
    By selectDepartureDateText = By.xpath("//*[@text='Select departure date']");
    By confirmDates = By.xpath("//*[@text='Confirm dates']");
    By chooseOutboundFlightText=By.xpath("//*[@text='Choose an outbound flight']");
    //By availableFlights = By.xpath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='11:20'] and ./*[@text='AMS'] and ./*[@text='06:50']]");
    By availableFlights = By.xpath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']");
    By lightBrandedFare=By.xpath("//*[@text='LIGHT']");
    By standardBrandedFare =By.xpath("//*[@text='STANDARD']");
    By flexBrandedFare =By.xpath("//*[@text='FLEX']");
    By selectBrandedFareButton = By.xpath("//*[@accessibilityLabel='Select' and @class='CoreAppRedesign.KLMAppButton' and @hidden='false' and @visible='true']");
    By chooseReturnFlightText=By.xpath("//*[@text='Choose a return flight']");
    By returnAvailableFlights = By.xpath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='Direct'] and ./*[@text='BCN']]");
    //By returnSelectBrandedFareButton = By.xpath("//*[@text='Select']");
    public By availableFlightsElement(){
        return availableFlights;
    }


   /* public List<WebElement> availableFlights(){
        return driver.findElements(availableFlights);
    }
    public WebElement selectedFlight(int number){
       return availableFlights().get(number);

    }*/
    public By lightBrandedFare(){
        return lightBrandedFare;
    }
    public By standardBrandedFare(){
        return standardBrandedFare;
    }
    public By flexBrandedFare(){
        return flexBrandedFare;
    }
    public By selectBrandedFareButtonBy(){
        return selectBrandedFareButton;
    }



    //int date = 6;
    public WebElement selectlightBrandedFare(){
        return driver.findElement(lightBrandedFare);
    }
    public WebElement selectStandardBrandedFare(){
        return driver.findElement(standardBrandedFare);
    }
    public WebElement selectFlexBrandedFare(){
        return driver.findElement(flexBrandedFare);
    }


    public WebElement selectBrandedFareButton(){
        return driver.findElement(selectBrandedFareButton);
    }
    public By chooseOutboundFlightText(){
        return chooseOutboundFlightText;
    }
    public By chooseReturnFlightText(){
        return chooseReturnFlightText;
    }
    public WebElement returnAvailableOffers(){
        return driver.findElement(returnAvailableFlights);
    }




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
    public By returnFlights = By.xpath("//*[@accessibilityLabel='BCN']");
    public WebElement dateSelection(int date){
        String oldDate = "//*[@text='date' and @textColor='0x031E2E' and @hidden='false' and @visible='true']";
        String newDate = oldDate.replace("date",Integer.toString(date));
        By departureDate = By.xpath(newDate);
        return driver.findElement(departureDate);
    }
    public By departureDateBy(int date){
        String oldDate = "//*[@text='date' and @textColor='0x031E2E' and @hidden='false' and @visible='true']";
        String newDate = oldDate.replace("date",Integer.toString(date));
        By departureDate = By.xpath(newDate);
        return departureDate;
    }
    public WebElement returnDate(int date){
        String oldDate = "//*[@text='date']";
        String newDate = oldDate.replace("date",Integer.toString(date));
        By returnDate = By.xpath(newDate);
        return driver.findElement(returnDate);
    }
    public void returnFlight(){
        returnAvailableOffers();


    }
    //Returns ConfirmDates button
    public WebElement confirmDatesButton(){
        return driver.findElement(confirmDates);
    }
    public WebElement availableFlights(){
        return (WebElement) driver.findElements(availableFlights).get(0);
        //return driver.findElement(availableFlights);
        //return driver.findElement(availableFlights);


    }
    /*public WebElement returnSelectedBrandedFareButton(){
        return driver.findElement(returnSelectBrandedFareButton);
    }*/

}
