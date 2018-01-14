package setup;

import org.junit.Test;
import org.openqa.selenium.By;

public class Check extends Setup {
    @Test
    public void test(){
        driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
    }
}
