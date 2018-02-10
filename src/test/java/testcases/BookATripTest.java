package testcases;


import org.junit.Test;

import pageobjects.HomePage;
import pageobjects.bookATrip.BookATripPage;
import pageobjects.bookATrip.PersonalDetails;
import setup.NewSetup;
import setup.Setup;
import setup.Utilities;

public class BookATripTest extends NewSetup {
    @Test
    public void bookATrip() throws InterruptedException {
        //BookATripPage bookATripPage = new BookATripPage(driver);
       BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        PersonalDetails personalDetails = new PersonalDetails(driver);
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
        bookATripPage.departureDate((utilities.currentDate())+2).click();
        bookATripPage.returnDate((utilities.currentDate())+4).click();
        bookATripPage.confirmDatesButton().click();
        Utilities.waitForElement(driver,bookATripPage.chooseOutboundFlightText());

        bookATripPage.availableFlights().click();
        Utilities.waitForElement(driver,bookATripPage.lightBrandedFare());
        bookATripPage.selectlightBrandedFare().click();
        bookATripPage.selectBrandedFareButton().click();
        Utilities.waitForElement(driver,bookATripPage.chooseReturnFlightText());
        bookATripPage.returnAvailableOffers().click();
        bookATripPage.returnSelectedBrandedFareButton().click();
        Utilities.waitForElement(driver,personalDetails.personalDetailsText());
        utilities.swipeWhileNotFound(personalDetails.getTitle());









    }
}
