package setup;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.boon.Str;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class Sample  {
    IOSDriver driver=Setup.initializeDriver();
    public String volum="data";

    public Sample() throws MalformedURLException {
    }


    IOSElement login =(IOSElement)driver.findElement(By.xpath("//*[@text='Log in']"));
    IOSElement username=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']"));
    IOSElement password=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']"));





    public IOSElement getLogin() {
        return login;
    }

    public IOSElement getUsername() {
        return username;
    }

    public IOSElement getPassword() {
        return password;
    }

    @Test
    public  void main() throws MalformedURLException {
//        Sample sample= new Sample();
        //System.out.print("String is"+sample.getData());
       // driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
    }
   /* @After
    public void teardown(){
        driver.quit();
    }*/
}
