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

    By travelParty = By.xpath("//*[@text='1 adult in Economy Class']");

    //By bookATrip=By.xpath("//*[@class='UIAView' and @height>0 and ./*[@text='Btm_Normal_BookATrip']]");
    By bookATrip=By.xpath("//*[@class='UIAView' and @height>0 and ./*[contains(text(),'BookATrip') and contains(text(),'Btm') ]]  ");
    public WebElement myTrips(){
        return driver.findElement(myTrips);
    }
    public WebElement bookATrip(){
        return driver.findElement(bookATrip);
    }

}
