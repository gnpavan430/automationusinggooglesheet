package setup;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlyingBlue {
    IOSDriver driver;
    By flyingBlue=By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]");
    By instrumentedFlyingBlue = By.xpath("//*[@class='UIImageView' and @width>0 and @height>0 and ./parent::*[@class='UIView'] and ./following-sibling::*[@text='Flying Blue']]");
    By flyingBlueNumberText = By.xpath("//*[@text='Flying Blue number']");
    By flyingBlueText=By.xpath("//*[@text='Log in']");
    By flyingBlueErrorText=By.xpath("//*[@text=concat('Sorry, we can', \"'\", 't find your Flying Blue details at the moment. Our bad! Please try again later.')]");
    public FlyingBlue(IOSDriver driver){
        this.driver=driver;
    }
    public WebElement flyingBlue(){
        return driver.findElement(flyingBlue);
    }
    public WebElement instrumentedFlyingBlue(){
        return driver.findElement(instrumentedFlyingBlue);
    }
    public By instrumentedFlyingBlueBy(){
      return instrumentedFlyingBlue;
    }
    public WebElement flyingBlueNumberText(){
        return driver.findElement(flyingBlueNumberText);
    }
    public By flyingBlueLoginText(){
        return flyingBlueText;
    }

    public By getFlyingBlueErrorText() {
        return flyingBlueErrorText;
    }

    public By getFlyingBlue() {
        return flyingBlue;
    }

    public By getFlyingBlueNumberText() {
        return flyingBlueNumberText;
    }
}
