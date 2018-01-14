package testcases;

import org.testng.annotations.Test;
import pageobjects.BookATripPage;
import setup.Setup;
import setup.Utilities;

public class BookATrip extends Setup {
    @Test
    public void bookATrip() throws InterruptedException {
        BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        bookATripPage.origin().click();

        bookATripPage.originSearchBar().sendKeys("ams");
        bookATripPage.originSearchResult().click();
        bookATripPage.destination().click();
        bookATripPage.destinationSearchBar().sendKeys("bcn");
        bookATripPage.destinationSearchResult().click();
        bookATripPage.selectTravelDates().click();
        utilities.waitForElement(driver,bookATripPage.selectDepartureDateText());
        //Thread.sleep(20000);
        bookATripPage.departureDate().click();

    }
}
