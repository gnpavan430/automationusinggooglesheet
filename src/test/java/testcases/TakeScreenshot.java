package testcases;

import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.bookATrip.BookATripPage;
import pageobjects.bookATrip.PersonalDetails;
import setup.Setup;
import setup.Utilities;

public class TakeScreenshot extends Setup {
    @Test
    public void takeScreenshot() throws InterruptedException {
        Thread.sleep(4000);
        /*BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        PersonalDetails personalDetails = new PersonalDetails(driver);
        HomePage homePage = new HomePage(driver);
        homePage.bookATrip().click();

        bookATripPage.origin().click();*/
        Utilities.captureScreenshot(driver,"FirstScreenshot");
    }
}
