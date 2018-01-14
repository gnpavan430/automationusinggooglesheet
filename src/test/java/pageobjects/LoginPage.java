package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    // public static IOSDriver driver;
    static String apple = "apple";
    IOSDriver driver;
    public LoginPage(IOSDriver driver){
        this.driver=driver;
    }

    By login = By.xpath("//*[@text='Log in']");
    By username= By.xpath("//*[@XCElementType='XCUIElementTypeTextField']");
    By password= By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']");
    By loginButton = By.xpath("//*[@text='Log in' and ./parent::*[@class='UIAView']]");
    By loginScreenHeaderText= By.xpath("//*[@text='Log in' and ./parent::*[@class='UIANavigationBar']]");


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