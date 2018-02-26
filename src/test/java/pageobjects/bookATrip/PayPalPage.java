package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PayPalPage {
    IOSDriver driver;
    public PayPalPage(IOSDriver driver){
        this.driver=driver;

    }
    public By paypalBackButton = By.xpath("//*[@value='Return to KLM']");
    public By paypalTitleText = By.xpath("//*[@text='Pay with PayPal']");
    public By paypalUserName = By.xpath("//*[@id='email']");
    public By paypalPasswordField = By.xpath("//*[@id='password']");
    public By loginButton = By.xpath("//*[@id='btnLogin']");
    public WebElement paypalBackButton(){
        return driver.findElement(paypalBackButton);
    }
    public By paypalTitleTextBy(){
        return paypalTitleText;
    }
    public WebElement paypalTitleText(){
        return driver.findElement(paypalTitleText);
    }
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement username(){
        return driver.findElement(paypalUserName);
    }
    public WebElement password(){
        return driver.findElement(paypalPasswordField);
    }
}
