package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewLoginPage {
    // public static IOSDriver driver;
    static String apple = "apple";
    IOSDriver driver;
    public NewLoginPage(IOSDriver driver){
        this.driver=driver;
    }

    By login = By.xpath("//*[@text='Log in']");
    //By username= By.xpath("//*[@XCElementType='XCUIElementTypeTextField']");
    //By password= By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']");
    By usernameWithID = By.xpath("//*[@class='UITextFieldLabel' and @textColor='0x061B2B']");
    By username = By.xpath("//*[@text='E-mail address or Flying Blue number' and @class='UITextFieldLabel']");
    By password = By.xpath("//*[@accessibilityLabel='PIN code or password']");
    By pass =By.xpath("//*[@accessibilityLabel='PIN code or password']");
    By loginButton = By.xpath("//*[@text='Log in' and ./parent::*[@class='CoreAppRedesign.TCARAppButton']]");
    By loginScreenHeaderText= By.xpath("//*[@text='Log in' and ./parent::*[@class='CoreAppRedesign.CustomNavigationBar']]");
    By notNow = By.xpath("//*[@text='Not now']");



    /*public WebElement username(){
        return driver.findElement(username);
    }
    public WebElement password(){
        return driver.findElement(password);
    }*/
    public WebElement notNow(){
        return driver.findElement(notNow);
    }
    public WebElement usernameWithID(){
        return driver.findElement(usernameWithID);
    }
    public WebElement username(){
        return driver.findElement(username);
    }
    public WebElement password(){
        return driver.findElement(password);
    }
    public WebElement login(){
        return driver.findElement(login);
    }
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }

    public By loginScreenHeaderText(){
        return loginScreenHeaderText;

    }









}