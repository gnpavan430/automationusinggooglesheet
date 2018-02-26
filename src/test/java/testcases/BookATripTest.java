package testcases;


/*
import org.junit.After;
import org.junit.Test;
*/

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.NewLoginPage;
import pageobjects.bookATrip.*;
import setup.FlyingBlue;
import setup.NewSetup;
import setup.Setup;
import setup.Utilities;
import Utilities.GenerateReport;

import java.util.Set;
//import Utilities.JUnitTestReporter;

public class BookATripTest extends NewSetup {
    @Test
    public void bookATrip() throws InterruptedException {
        //BookATripPage bookATripPage = new BookATripPage(driver);
     BookATripHomePage bookATripHomePage = new BookATripHomePage(driver);
     PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage(driver);
        DCPPage dcpPage = new DCPPage(driver);
     FlyingBlue flyingBlue = new FlyingBlue(driver);

       BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        PersonalDetails personalDetails = new PersonalDetails(driver);
        HomePage homePage = new HomePage(driver);
     NewLoginPage newLoginPage = new NewLoginPage(driver);

     flyingBlue.instrumentedFlyingBlue().click();
     if((utilities.checkElementVisibility(flyingBlue.getFlyingBlueNumberText()))){
      newLoginPage.login().click();
      // newLoginPage.username().click();
      newLoginPage.usernameWithID().clear();
      newLoginPage.username().sendKeys("2122638964");
      //newLoginPage.password().click();
      newLoginPage.password().sendKeys("123456");
      newLoginPage.loginButton().click();
      newLoginPage.notNow().click();
     }

     Utilities.waitForElement(driver,homePage.bookATripButton());
     Thread.sleep(4000);

     homePage.bookATrip().click();


        bookATripPage.origin().click();

        bookATripPage.originSearchBar().sendKeys("ams");
        bookATripPage.originSearchResult().click();
        bookATripPage.destination().click();
        bookATripPage.destinationSearchBar().sendKeys("bcn");
        bookATripPage.destinationSearchResult().click();
        bookATripPage.selectTravelDates().click();
        /*Utilities.waitForElement(driver,bookATripHomePage.noThanksButtonElement());
        bookATripHomePage.noThanksButton().click();*/

        utilities.waitForElement(driver,bookATripPage.selectDepartureDateText());
        //Thread.sleep(20000);
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(4)));
       /* while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(4))).size()==0){
            Utilities.swipe(driver);
        }*/
        bookATripPage.dateSelection((utilities.currentDate(4))).click();
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(11)));

       /* while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(11))).size()==0){
            Utilities.swipe(driver);
        }*/

        bookATripPage.dateSelection((utilities.currentDate(11))).click();
        bookATripPage.confirmDatesButton().click();
        Utilities.waitForElement(driver,bookATripPage.chooseOutboundFlightText());

        //Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());
       //bookATripPage.availableFlights();
        Thread.sleep(4000);
        bookATripPage.availableFlights().click();
        Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());


        //bookATripPage.availableFlights().click();
        //Utilities.waitForElement(driver,bookATripPage.lightBrandedFare());
        if((driver.findElements(bookATripPage.lightBrandedFare()).size())>0){
            bookATripPage.selectlightBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectStandardBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectFlexBrandedFare().click();
        }

       if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
        }

        Utilities.waitForElement(driver,bookATripPage.chooseReturnFlightText());
        Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());

        System.out.println("Flight elements are");
        driver.findElementByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='BCN'] and ./*[@text='06:00']]").click();
       // bookATripPage.availableFlights().click();
        //driver.findElement(By.xpath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']")).click();

        if((driver.findElements(bookATripPage.lightBrandedFare()).size())>0){
            bookATripPage.selectlightBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectStandardBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectFlexBrandedFare().click();
        }

        if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
        }

        //bookATripPage.returnSelectedBrandedFareButton().click();
        Utilities.waitForElement(driver,personalDetails.personalDetailsText());
        personalDetails.personalDetails().click();
        /*while((utilities.checkElementVisibility(personalDetails.getTitle()))!=true){
         Utilities.swipe();
        }*/
      /*  do{
         Utilities.swipe(driver);
         if(driver.findElement())

        }while(!(utilities.checkElementVisibility(personalDetails.continueToPaymentButtonBy())));*/
      Utilities.swipe(driver,personalDetails.continueToPaymentButtonBy());
        /*while((driver.findElements(personalDetails.continueToPaymentButtonBy()).size()==0)){
         Utilities.swipe(driver);
        }*/

        //Utilities.swipeWhileNotFound(personalDetails.getTitle());
       /* personalDetails.title().click();
        personalDetails.titleMr().click();*/
       //Utilities.swipeWhileNotFound(driver,personalDetails.continueToPaymentButtonBy());
       personalDetails.continueToPaymentButton().click();
       Utilities.waitForElement(driver,paymentOptionsPage.payWith());
       //Getting total price in payment options screen before navigating to DCP
       String paymentOptionsPriceBefore = paymentOptionsPage.totalPrice().getText().trim();
       System.out.println("Payment options price is"+paymentOptionsPriceBefore);
       Utilities.swipe(driver,paymentOptionsPage.checkBox());
       /* while((driver.findElements(paymentOptionsPage.checkBox()).size()==0)){
            Utilities.swipe(driver);
        }
        Utilities.swipe(driver);*/

        paymentOptionsPage.checkbox().click();
        paymentOptionsPage.continueToPaymentButtonEnabled().click();
        Utilities.waitForElement(driver,dcpPage.titleText);
        Set<String> contexts = driver.getContextHandles();
        for(String contextNames:contexts){
            System.out.println("Available contexts are"+contextNames);
        }
        driver.context("WEBVIEW_1");
        String dcpPrice = dcpPage.price().getText().trim();
        System.out.println("DCP page price is"+dcpPrice);
        driver.context("NATIVE_APP_INSTRUMENTED");
        Thread.sleep(4000);
        dcpPage.closeButton().click();
        dcpPage.goBackButton().click();
        Utilities.waitForElement(driver,paymentOptionsPage.payWith());
        String paymentOptionsPriceAfter = paymentOptionsPage.totalPrice().getText().trim();
        Assert.assertEquals(dcpPrice,paymentOptionsPriceBefore);
        Assert.assertEquals(dcpPrice,paymentOptionsPriceAfter);
        Assert.assertEquals(paymentOptionsPriceBefore,paymentOptionsPriceAfter);















    }

    @Test(dataProvider = "Authentication")
    public void bookATripNormalPayment(String mainPayment,String subPayment) throws InterruptedException {
        PayPalPage payPalPage = new PayPalPage(driver);
        BookATripHomePage bookATripHomePage = new BookATripHomePage(driver);
        PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage(driver);
        DCPPage dcpPage = new DCPPage(driver);
        FlyingBlue flyingBlue = new FlyingBlue(driver);

        BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        PersonalDetails personalDetails = new PersonalDetails(driver);
        HomePage homePage = new HomePage(driver);
        NewLoginPage newLoginPage = new NewLoginPage(driver);

        flyingBlue.instrumentedFlyingBlue().click();
        if((utilities.checkElementVisibility(flyingBlue.getFlyingBlueNumberText()))){
            newLoginPage.login().click();
            // newLoginPage.username().click();
            newLoginPage.usernameWithID().clear();
            newLoginPage.username().sendKeys("2122638964");
            //newLoginPage.password().click();
            newLoginPage.password().sendKeys("123456");
            newLoginPage.loginButton().click();
            newLoginPage.notNow().click();
        }

        Utilities.waitForElement(driver,homePage.bookATripButton());
        Thread.sleep(4000);

        homePage.bookATrip().click();


        bookATripPage.origin().click();

        bookATripPage.originSearchBar().sendKeys("ams");
        bookATripPage.originSearchResult().click();
        bookATripPage.destination().click();
        bookATripPage.destinationSearchBar().sendKeys("bcn");
        bookATripPage.destinationSearchResult().click();
        bookATripPage.selectTravelDates().click();
        /*Utilities.waitForElement(driver,bookATripHomePage.noThanksButtonElement());
        bookATripHomePage.noThanksButton().click();*/

        utilities.waitForElement(driver,bookATripPage.selectDepartureDateText());
        //Thread.sleep(20000);
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(10)));
        /*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(4))).size()==0){
            Utilities.swipe(driver);
        }*/
        bookATripPage.dateSelection((utilities.currentDate(10))).click();
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(17)));

        /*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(11))).size()==0){
            Utilities.swipe(driver);
        }*/

        bookATripPage.dateSelection((utilities.currentDate(17))).click();
        bookATripPage.confirmDatesButton().click();
        Utilities.waitForElement(driver,bookATripPage.chooseOutboundFlightText());

        //Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());
        //bookATripPage.availableFlights();
        Thread.sleep(4000);
        bookATripPage.availableFlights().click();
        Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());


        //bookATripPage.availableFlights().click();
        //Utilities.waitForElement(driver,bookATripPage.lightBrandedFare());
        if((driver.findElements(bookATripPage.lightBrandedFare()).size())>0){
            bookATripPage.selectlightBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectStandardBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectFlexBrandedFare().click();
        }

        if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
        }

        Utilities.waitForElement(driver,bookATripPage.chooseReturnFlightText());
        Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());

        System.out.println("Flight elements are");
        driver.findElementByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='BCN'] and ./*[@text='06:00']]").click();
        // bookATripPage.availableFlights().click();
        //driver.findElement(By.xpath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']")).click();

        if((driver.findElements(bookATripPage.lightBrandedFare()).size())>0){
            bookATripPage.selectlightBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectStandardBrandedFare().click();

        }
        else if((driver.findElements(bookATripPage.standardBrandedFare()).size())>0){
            bookATripPage.selectFlexBrandedFare().click();
        }

        if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
        }

        //bookATripPage.returnSelectedBrandedFareButton().click();
        Utilities.waitForElement(driver,personalDetails.personalDetailsText());
        personalDetails.personalDetails().click();
        /*while((utilities.checkElementVisibility(personalDetails.getTitle()))!=true){
         Utilities.swipe();
        }*/
      /*  do{
         Utilities.swipe(driver);
         if(driver.findElement())

        }while(!(utilities.checkElementVisibility(personalDetails.continueToPaymentButtonBy())));*/
       Utilities.swipe(driver,personalDetails.continueToPaymentButtonBy());
        /*while((driver.findElements(personalDetails.continueToPaymentButtonBy()).size()==0)){
            Utilities.swipe(driver);
        }*/

        //Utilities.swipeWhileNotFound(personalDetails.getTitle());
       /* personalDetails.title().click();
        personalDetails.titleMr().click();*/
        //Utilities.swipeWhileNotFound(driver,personalDetails.continueToPaymentButtonBy());
        personalDetails.continueToPaymentButton().click();
        Utilities.waitForElement(driver,paymentOptionsPage.payWith());
        String paymentOptionsPriceBefore = paymentOptionsPage.totalPrice().getText().trim();
       // Utilities.swipe(driver,paymentOptionsPage.changePaymentMethodBy());
        if(driver.findElements(By.xpath("//*[@text='Change payment method']")).size()>0){
            paymentOptionsPage.changePaymentMethod().click();
        }
        Utilities.waitForElement(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        paymentOptionsPage.paymentMethodElement(mainPayment).click();
        if(!(subPayment.equalsIgnoreCase("PayPal"))){
            Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(subPayment));
            paymentOptionsPage.paymentMethodElement(subPayment).click();
        }

        if((subPayment.equalsIgnoreCase("Visa")) || (subPayment.equalsIgnoreCase("MasterCard"))){

        }
        //paymentOptionsPage.paymentMethodElement(paymentCreditCard).click();
        /*while((driver.findElements(paymentOptionsPage.creditCardPaymentMethodElementBy(paymentCreditCard)).size()==0)){
            Utilities.swipe(driver);
        }*/
        /*if((paymentCreditCard.equalsIgnoreCase("Diners Club")) || (paymentCreditCard.equalsIgnoreCase("UATP"))){
            Utilities.swipe(driver);
        }*/

        Utilities.swipe(driver,paymentOptionsPage.checkBox());
       /* while((driver.findElements(paymentOptionsPage.checkBox()).size()==0)){
            Utilities.swipe(driver);
        }*/
        //Utilities.swipe(driver);

        paymentOptionsPage.checkbox().click();
        paymentOptionsPage.continueToPaymentButtonEnabled().click();
        Utilities.waitForElement(driver,dcpPage.titleText);
        Set<String> contexts = driver.getContextHandles();
        for(String contextNames:contexts){
            System.out.println("Available contexts are"+contextNames);
        }
        driver.context("WEBVIEW_1");
        String dcpPrice = dcpPage.price().getText().trim().replace(',','.');
        System.out.println("DCP page price is"+dcpPrice);
        driver.context("NATIVE_APP_INSTRUMENTED");
        Thread.sleep(4000);
        dcpPage.closeButton().click();
        dcpPage.goBackButton().click();
        Utilities.waitForElement(driver,paymentOptionsPage.payWith());
        String paymentOptionsPriceAfter = paymentOptionsPage.totalPrice().getText().trim();
        if((mainPayment.equalsIgnoreCase("PayPal"))){
             driver.context("WEBVIEW_1");
             Utilities.waitForElement(driver,payPalPage.paypalTitleText);
             payPalPage.username().clear();
             payPalPage.username().sendKeys("testblue@klm.com");
             payPalPage.password().sendKeys("klmmobile");
             payPalPage.loginButton().click();



        }

        Assert.assertEquals(dcpPrice,paymentOptionsPriceBefore);
        Assert.assertEquals(dcpPrice,paymentOptionsPriceAfter);
        Assert.assertEquals(paymentOptionsPriceBefore,paymentOptionsPriceAfter);




    }
    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        //return new Object[]  { "Air France KLM" ,  "JCB","Diners Club","UATP"};
        return new Object[][]{{"banking","ABN AMRO"},{"Credit card","Diners"},{"PayPal",""}};

    }

}
