package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PersonalDetails {
    IOSDriver driver;
    public PersonalDetails(IOSDriver driver){
        this.driver=driver;

    }
    By personalDetailsText = By.xpath("//*[@text='Personal details']");
    By title = By.xpath("//*[@text='Title' and @visible='true']");
    By firstName = By.xpath("//*[@text='First name' and @visible='true']");
    By lastName = By.xpath("//*[@text='Last name' and @visible='true']");
    By emailAddress = By.xpath("//*[@text='E-mail address' and @visible='true']");
    By countryCode = By.xpath("//*[@text='Country code' and @visible='true']");
    By titleMr = By.xpath("//*[@text='Mr' and @top='true']");
    By continueToPaymentButton = By.xpath("//*[@accessibilityLabel='Continue to payment']");

    public By getTitle() {
        return title;

    }
    public WebElement title(){
        return driver.findElement(title);
    }


    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getEmailAddress() {
        return emailAddress;
    }

    public By getCountryCode() {
        return countryCode;
    }

    public By getTelePhoneNumber() {
        return telePhoneNumber;
    }

    public By getLoyalityProgram() {
        return loyalityProgram;
    }

    By telePhoneNumber = By.xpath("//*[@text='Telephone number 1' and @visible='true']");
    By loyalityProgram = By.xpath("//*[@text='Loyalty programme (optional)' and @visible='true']");

    public By getFlyingBlueNumber() {
        return flyingBlueNumber;
    }
    public By continueToPaymentButtonBy(){
        return continueToPaymentButton;
    }
    public WebElement continueToPaymentButton(){
        return driver.findElement(continueToPaymentButton);
    }

    By flyingBlueNumber = By.xpath("//*[@text='frequent flyer number' and @visible='true']");
    public WebElement personalDetails(){
        return driver.findElement(personalDetailsText);
    }
    public WebElement titleMr(){
        return driver.findElement(titleMr);
    }




    public By personalDetailsText(){
        return personalDetailsText;
    }
}
