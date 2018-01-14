package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        this.driver=driver;
    }
    By myTrips=By.xpath("//*[@text='My trips' and ./parent::*[@class='UIAView']]");
    public WebElement myTrips(){
        return driver.findElement(myTrips);
    }
}
