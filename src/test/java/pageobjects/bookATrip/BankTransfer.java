package pageobjects.bookATrip;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BankTransfer {
    IOSDriver driver;
    public BankTransfer(IOSDriver driver){
        this.driver=driver;

    }
    public By cityOfResidence = By.xpath("//*[@accessibilityIdentifier='BTTxtCity' and @visible='true']");
    public By familyName=By.xpath("//*[@accessibilityIdentifier='BTTxtFamilyName' and @visible='true']");
    public By bankCity = By.xpath("//*[@accessibilityIdentifier='BTTextBankCity' and @visible='true']");
    public WebElement cityOfResidence(){
        return driver.findElement(cityOfResidence);
    }
    public WebElement familyName(){
        return driver.findElement(familyName);
    }
    public WebElement bankCity(){
        return driver.findElement(bankCity);
    }
}
