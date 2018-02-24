package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DCPPage {
    IOSDriver driver;
    public DCPPage(IOSDriver driver){
        this.driver=driver;

    }
    public By titleText = By.xpath("//*[@accessibilityLabel='Pay']");
    public By closeButton = By.xpath("//*[@accessibilityIdentifier='NavigationBarCloseWhite.png']");
    public By goBackButton = By.xpath("//*[@text='Go back']");
    public By price = By.xpath("//*[@class='price']");
    public WebElement closeButton(){
        return driver.findElement(closeButton);
    }
    public WebElement goBackButton(){
        return driver.findElement(goBackButton);
    }
    public WebElement price(){
        return driver.findElement(price);
    }

}
