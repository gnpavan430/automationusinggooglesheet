package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

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

    public By getTitle() {
        return title;
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

    By flyingBlueNumber = By.xpath("//*[@text='frequent flyer number' and @visible='true']");




    public By personalDetailsText(){
        return personalDetailsText;
    }
}
