package testcases;


import org.junit.Test;
import pageobjects.BookATripPage;
import pageobjects.HomePage;
import setup.Setup;
import setup.Utilities;

public class BookATripTest extends Setup {
    @Test
    public void bookATrip() throws InterruptedException {
        BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        HomePage homePage = new HomePage(driver);
        homePage.bookATrip().click();

        bookATripPage.origin().click();

        bookATripPage.originSearchBar().sendKeys("ams");
        bookATripPage.originSearchResult().click();
        bookATripPage.destination().click();
        bookATripPage.destinationSearchBar().sendKeys("bcn");
        bookATripPage.destinationSearchResult().click();
        bookATripPage.selectTravelDates().click();
        utilities.waitForElement(driver,bookATripPage.selectDepartureDateText());
        //Thread.sleep(20000);
        bookATripPage.departureDate((utilities.currentDate())+7).click();
        bookATripPage.returnDate((utilities.currentDate())+9).click();
        bookATripPage.confirmDatesButton().click();
        bookATripPage.availableFlights().get(1).click();
        bookATripPage.selectlightBrandedFare().click();
        bookATripPage.selectBrandedFareButton().click();





    }
}
