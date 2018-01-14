package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Profile {
    IOSDriver driver;
    public Profile(IOSDriver driver){
        this.driver=driver;
    }
    //By profileButton = By.xpath("//*[@class='UIView' and @width>0 and ./*[@class='UIImageView'] and ./*[@text='Profile']]");
    By profileButton= By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Profile']]");//Non instrumented mode
    By logoutButton = By.xpath("//*[@class='UIAButton']");//Non instrumented mode
    By alertTextLogout= By.xpath("//*[@text='Log out' and @class='UIAButton']");//Non instrumented mode
    By alertTextCancel= By.xpath("//*[@text='Cancel']");//Non instrumented mode
    By loginButton= By.xpath("//*[@class='UIAButton']");

    public WebElement profileButton(){
        return driver.findElement(profileButton);
    }
    public WebElement logoutButton(){
        return driver.findElement(logoutButton);
    }
    public WebElement alertTextLogout(){
        return driver.findElement(alertTextLogout);
    }
    public WebElement alertTextCancel(){
        return driver.findElement(alertTextCancel);
    }
    public WebElement loginButton(){
        return driver.findElement(loginButton);
    }
    public By loginButtonText(){
        return loginButton;
    }

}
