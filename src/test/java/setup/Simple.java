package setup;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simple extends Setup {
    /*public  String data="abcd";

    public  String getData() {
        return data;
    }
    IOSElement flyingBlue=(IOSElement)driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]"));
    IOSElement login =(IOSElement)driver.findElement(By.xpath("//*[@text='Log in']"));
    IOSElement username=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']"));
    IOSElement password=(IOSElement)driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']"));


    public void setData(String data) {
        this.data = data;
    }*/
    public static void main(String args[]) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        System.out.println("Date is"+date);
        String dt=date.toString();

        int dt1= Integer.parseInt(dt.substring(8,10));
        System.out.println("date is"+dt1);

       /* String date1 = String.valueOf(dateFormat.parse(String.valueOf(date)));
        int dt = Integer.parseInt(date1);
        System.out.println(dt);*/
    }
}
