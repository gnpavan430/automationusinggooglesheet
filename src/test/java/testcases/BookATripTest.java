package testcases;


/*
import org.junit.After;
import org.junit.Test;
*/

import com.relevantcodes.extentreports.ExtentReports;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.NewLoginPage;
import pageobjects.TripDetails;
import pageobjects.bookATrip.*;
import setup.*;
import Utilities.GenerateReport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import Utilities.JUnitTestReporter;

public class BookATripTest extends NewSetup {
//    IOSDriver driver=initializeDriver();
public static ArrayList<String>data=new ArrayList<>();
    public static String network;


    public BookATripTest() throws MalformedURLException {
    }

    public void initialize() throws MalformedURLException {
        //initializeDriver();


    }


    @Test
    public void bookATrip() throws InterruptedException, MalformedURLException {
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
       bookATripTillPaymentPage(driver);
      // bookATripTillPaymentPage();
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
    public void bookATripCompleteFlow(String network,String mainPayment,String subPayment)  {
        data.clear();
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
        BankTransfer bankTransfer = new BankTransfer(driver);
        TripDetails tripDetails = new TripDetails(driver);
        PaymentConfirmationPage paymentConfirmationPage = new PaymentConfirmationPage(driver);
        GetLogs getLogs=new GetLogs();
        Quickstart quickstart = new Quickstart();
        if(network.equalsIgnoreCase("Good network")){
            utilities.setNetwork(driver,utilities.getGoodNetwork());
        }
        else if(network.equalsIgnoreCase("Bad Network")){
            utilities.setNetwork(driver,utilities.getBadNetwork());
        }
        else if(network.equalsIgnoreCase("Edge network")){
            utilities.setNetwork(driver,utilities.getEdgeNetwork());
        }
        try {
            loginSetUpForBookATrip(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //This is the method for taking API logs
        try {
            getLogs.startLogs();
            //startLogs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before starting booking process"+dateFormat.format(date));

        try {
            bookATripTillPaymentPage(driver);
        } catch (InterruptedException e) {
            data.clear();
            e.printStackTrace();
        }
        Utilities.waitForElement(driver,paymentOptionsPage.payWith());
        String paymentOptionsPriceBefore = paymentOptionsPage.totalPrice().getText().trim();
        // Utilities.swipe(driver,paymentOptionsPage.changePaymentMethodBy());
        if(driver.findElements(By.xpath("//*[@text='Change payment method']")).size()>0){
            paymentOptionsPage.changePaymentMethod().click();
        }
        Utilities.waitForElement(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        paymentOptionsPage.paymentMethodElement(mainPayment).click();
        if(!((mainPayment.equalsIgnoreCase("PayPal"))||(mainPayment.equalsIgnoreCase("Bank transfer")))){
            Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(subPayment));
            paymentOptionsPage.paymentMethodElement(subPayment).click();
        }
        if(mainPayment.equalsIgnoreCase("Bank transfer")){
            bankTransfer.cityOfResidence().sendKeys("New York");
            bankTransfer.familyName().sendKeys("Alex");
            bankTransfer.bankCity().sendKeys("New York");
            Utilities.hideKeyboard(driver);

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
        if(mainPayment.equalsIgnoreCase("Credit card")){
            Utilities.waitForElement(driver,dcpPage.titleText);
            Set<String> contexts = driver.getContextHandles();
            for(String contextNames:contexts){
                System.out.println("Available contexts are"+contextNames);
            }
            driver.context("WEBVIEW_1");
            String dcpPrice = dcpPage.price().getText().trim().replace(',','.');
            System.out.println("DCP page price is"+dcpPrice);
            driver.context("NATIVE_APP_INSTRUMENTED");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dcpPage.closeButton().click();
            dcpPage.goBackButton().click();
            Utilities.waitForElement(driver,paymentOptionsPage.payWith());
            String paymentOptionsPriceAfter = paymentOptionsPage.totalPrice().getText().trim();
            Assert.assertEquals(dcpPrice,paymentOptionsPriceBefore);
            Assert.assertEquals(dcpPrice,paymentOptionsPriceAfter);
            Assert.assertEquals(paymentOptionsPriceBefore,paymentOptionsPriceAfter);

        }

        if((mainPayment.equalsIgnoreCase("PayPal"))){
            driver.context("WEBVIEW_1");
            Utilities.waitForElement(driver,payPalPage.paypalTitleText);
            payPalPage.username().clear();
            payPalPage.username().sendKeys("testblue@klm.com");
            payPalPage.password().sendKeys("klmmobile");
            payPalPage.loginButton().click();


        }
        if(mainPayment.equalsIgnoreCase("Bank transfer")){
            Utilities.waitForElement(driver,paymentConfirmationPage.paymentConfirmationTitleTextBy());
            Utilities.swipe(driver,paymentConfirmationPage.viewYourBookingBy());
            paymentConfirmationPage.viewYourBooking().click();
            Utilities.waitForElement(driver,tripDetails.getAddToCalendarButton());
            /*tripDetails.backButton().click();
            utilities.getConsoleLogs(driver);*/

        }
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        //long totalTime= TimeUnit.MILLISECONDS.toSeconds(diff)-4000;
        long totalTime = TimeUnit.MILLISECONDS.toSeconds(diff-4000);

        //double value = Utilities.timeFormatter(diff);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for booking a Trip"+totalTime);

        //Method to stop taking logs
        try {
            getLogs.stopLogs();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            data.clear();
            e.printStackTrace();
        }
        try {
            data=getLogs.readData();
        } catch (FileNotFoundException e) {
            data.clear();
            e.printStackTrace();
        }
        ArrayList<String> result = new ArrayList<String>();
        System.out.println("Total data is"+data);
        //Pattern pattern = Pattern.compile("200 'https://api.klm.com/travel/reservations\\/\\w+\\/$");
        for(int i=0;i<data.size();i++){
            if((data.get(i).contains("https://api.klm.com/travel/flightoffers/lowest-fare-offers/?type=OVERALL"))&(data.get(i).contains("CocoaLumberjack"))){
                result.add(data.get(i));

            }

           // Matcher matcher = pattern.matcher(data.get(i));
            if((data.get(i).contains("200 'https://api.klm.com/travel/reservations/"))&(data.get(i).contains("CocoaLumberjack"))){
                result.add(data.get(i));
                //data.get(i).matches("200 'https://api.klm.com/travel/reservations/^[a-zA-Z0-9_]*$/");

            }
        }
        System.out.println("Logs in result are"+result);
        long startResponseTime=Utilities.responseTime(result.get(0));
        long endResponseTime = Utilities.responseTime(result.get(result.size()-1));
        long responseTime=endResponseTime-startResponseTime;
        long apptime= totalTime-responseTime;
        System.out.println("starting time stamp"+result.get(0).substring(7,15));
        System.out.println("Ending time"+result.get(result.size()-1).substring(7,15));
        System.out.println("Response time in seconds is"+responseTime);
        Date timeStamp= new Date();

        try {
            quickstart.appendValuesBookATrip(network,timeStamp,totalTime,apptime,responseTime);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test(dataProvider = "Authentication")
    public void bookATripNormalPayment(String mainPayment,String subPayment) throws InterruptedException {
        PayPalPage payPalPage = new PayPalPage(driver);
        BookATripHomePage bookATripHomePage = new BookATripHomePage(driver);
        PaymentOptionsPage paymentOptionsPage = new PaymentOptionsPage(driver);
        DCPPage dcpPage = new DCPPage(driver);
        FlyingBlue flyingBlue = new FlyingBlue(driver);
        BankTransfer bankTransfer= new BankTransfer(driver);

        BookATripPage bookATripPage = new BookATripPage(driver);
        Utilities utilities = new Utilities();
        PersonalDetails personalDetails = new PersonalDetails(driver);
        HomePage homePage = new HomePage(driver);
        NewLoginPage newLoginPage = new NewLoginPage(driver);
       // bookATripTillPaymentPage();
        Utilities.waitForElement(driver,paymentOptionsPage.payWith());
        String paymentOptionsPriceBefore = paymentOptionsPage.totalPrice().getText().trim();
       // Utilities.swipe(driver,paymentOptionsPage.changePaymentMethodBy());
        if(driver.findElements(By.xpath("//*[@text='Change payment method']")).size()>0){
            paymentOptionsPage.changePaymentMethod().click();
        }
        Utilities.waitForElement(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(mainPayment));
        paymentOptionsPage.paymentMethodElement(mainPayment).click();
        if(!((mainPayment.equalsIgnoreCase("PayPal"))||(mainPayment.equalsIgnoreCase("Bank transfer")))){
            Utilities.swipe(driver,paymentOptionsPage.paymentElementBy(subPayment));
            paymentOptionsPage.paymentMethodElement(subPayment).click();
        }
        if(mainPayment.equalsIgnoreCase("Bank transfer")){
            bankTransfer.cityOfResidence().sendKeys("New York");
            bankTransfer.familyName().sendKeys("Alex");
            bankTransfer.bankCity().sendKeys("New York");

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
    public void loginSetUpForBookATrip(IOSDriver driver) throws InterruptedException {
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
        Thread.sleep(4000);
        Utilities.waitForElement(driver,flyingBlue.instrumentedFlyingBlueBy());
        flyingBlue.instrumentedFlyingBlue().click();
        if(utilities.checkElementVisibility(driver,flyingBlue.flyingBlueLoginText())){
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
    }

    public void bookATripTillPaymentPage(IOSDriver driver) throws InterruptedException {
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
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(14)));
        /*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(4))).size()==0){
            Utilities.swipe(driver);
        }*/
        bookATripPage.dateSelection((utilities.currentDate(14))).click();
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(21)));

        /*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(11))).size()==0){
            Utilities.swipe(driver);
        }*/

        bookATripPage.dateSelection((utilities.currentDate(21))).click();
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
        Utilities.swipe(driver,bookATripPage.selectBrandedFareButtonBy());


       // if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
        //}

        Utilities.waitForElement(driver,bookATripPage.chooseReturnFlightText());
        Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());
        bookATripPage.availableFlightsWebElement().click();

        //System.out.println("Flight elements are");
        //driver.findElementByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='BCN'] and ./*[@text='06:00']]").click();
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
        //Utilities.waitForElement(driver,bookATripPage.selectBrandedFareButtonBy());
        Utilities.swipe(driver,bookATripPage.selectBrandedFareButtonBy());

        //if((driver.findElements(bookATripPage.selectBrandedFareButtonBy()).size())>0){
            bookATripPage.selectBrandedFareButton().click();
       // }

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

    }
    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {

        //return new Object[]  { "Air France KLM" ,  "JCB","Diners Club","UATP"};
        //return new Object[][]{{"banking","ABN AMRO"},{"Credit card","Diners"},{"PayPal",""}};
        return new Object[][]{{"Good Network","Bank transfer",""},{"Bad Network","Bank transfer",""},{"Edge Network","Bank transfer",""}};
        //return new Object[][]{{"Bad Network","Bank transfer",""}};


    }

}
