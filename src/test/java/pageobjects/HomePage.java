package pageobjects;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        this.driver=driver;
    }
    By myTrips=By.xpath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='My trips'] and ./*[@class='UIImageView']]");

    By travelParty = By.xpath("//*[@text='1 adult in Economy Class']");

    //By bookATrip=By.xpath("//*[@class='UIAView' and @height>0 and ./*[@text='Btm_Normal_BookATrip']]");
    By bookATrip=By.xpath("//*[@class='UIImageView' and @width>0 and @height>0 and ./following-sibling::*[@text='Book'] and ./parent::*[@class='UIView' and @height>0]] ");
    public WebElement myTrips(){
        return driver.findElement(myTrips);
    }
    public WebElement bookATrip(){
        return driver.findElement(bookATrip);
    }

}
