package setup;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

public class Simple extends Setup {
    public  String data="abcd";

    public  String getData() {
        return data;
    }
    IOSElement flyingBlue=(IOSElement)driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]"));
    IOSElement login =(IOSElement)driver.findElement(By.xpath("//*[@text='Log in']"));
    IOSElement username=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']"));
    IOSElement password=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']"));


    public void setData(String data) {
        this.data = data;
    }
}
