package testcases;

import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import pageobjects.NewLoginPage;
import pageobjects.bookATrip.*;
import setup.FlyingBlue;
import setup.NewSetup;
import setup.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static final String EXAMPLE_TEST = "200 'https://api.klm.com/travel/reservations/b2806f275ab4222a9bbc3b0124ebd270/";
    //public static final String EXAMPLE_TEST = "abcd1355";
    public static void main(String args[]){
        //timeFormatter((long) 223983);
        Pattern pattern = Pattern.compile("200 'https://api.klm.com/travel/reservations\\/\\w+\\/$");
        //Pattern pattern = Pattern.compile("^\\w+$");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        System.out.println("Matcher is"+matcher);
        if ((matcher.find())& true){
            System.out.println("Pattern is matched");
        }
        else{
            System.out.println("Pattern is not matched");
        }
    }

    public static void timeFormatter(Long time){
        double seconds=time/1000;
        System.out.println("seconds:"+seconds);
        //double milliseconds=(double)(time%1000)/1000;
        double milliseconds=(double)(time%1000);
        long minutes = (long) (seconds/60);
        double sec=(double)(seconds%60);
        //System.out.println("Milli seconds:"+milliseconds);
        double duration=seconds+milliseconds;
        String value=""+minutes+"minutes"+sec+"Seconds"+milliseconds+"Milli Seconds";
        System.out.println("Value is"+value);
        //return duration;


    }









    /*@org.testng.annotations.Test
    public  void test() throws InterruptedException {
       // driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"NATIVE\", elementToFind, 0, 1000, 5, true)");
        //Thread.sleep(8000);
        //"invokeMethod:'{"selector":"currentLogFileData","arguments":[]}'")
        //String script = "invokeMethod:'{\"selector\":\"rollCurrentLogFile\",\"arguments\":[]}'";
        String script = "client:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@class='CoreAppRedesign.CustomNavigationBar']\", 0, \n" +
                "                    \"invokeMethod:'{\\\"selector\\\":\\\"currentLogFileContents\\\",\\\"arguments\\\":[]}'\");";
        //String script = "currentLogFileContents()";
        //String script = "\"invokeMethod:'{\"selector\":\"currentLogFileContents\",\"arguments\":[]}'";
        System.out.println(driver.executeScript(script));
 //System.out.println(driver.executeScript("client:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@class='CoreAppRedesign.CustomNavigationBar']\", 0,"+script+")"));
       //String data="client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@class='CoreAppRedesign.CustomNavigationBar']\", 0,invokeMethod:'{\"selector\":\"currentLogFileData\",\"arguments\":[]}')";
       //System.out.println("Data is"+data);
        *//*System.out.println(data.charAt(107));
        System.out.println(data.substring(100,110));*//*




    }

    @org.testng.annotations.Test
    public void flightOfferTest() throws InterruptedException {
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

        homePage.bookATrip().click();


        bookATripPage.origin().click();

        bookATripPage.originSearchBar().sendKeys("ams");
        bookATripPage.originSearchResult().click();
        bookATripPage.destination().click();
        bookATripPage.destinationSearchBar().sendKeys("bcn");
        bookATripPage.destinationSearchResult().click();
        bookATripPage.selectTravelDates().click();
        *//*Utilities.waitForElement(driver,bookATripHomePage.noThanksButtonElement());
        bookATripHomePage.noThanksButton().click();*//*

        utilities.waitForElement(driver,bookATripPage.selectDepartureDateText());
        //Thread.sleep(20000);
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(14)));
        *//*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(4))).size()==0){
            Utilities.swipe(driver);
        }*//*
        bookATripPage.dateSelection((utilities.currentDate(14))).click();
        Utilities.swipe(driver,bookATripPage.departureDateBy(utilities.currentDate(21)));

        *//*while(driver.findElements(bookATripPage.departureDateBy(utilities.currentDate(11))).size()==0){
            Utilities.swipe(driver);
        }*//*

        bookATripPage.dateSelection((utilities.currentDate(21))).click();
        bookATripPage.confirmDatesButton().click();
        Utilities.waitForElement(driver,bookATripPage.chooseOutboundFlightText());

        //Utilities.waitForElement(driver,bookATripPage.availableFlightsElement());
        //bookATripPage.availableFlights();
        Thread.sleep(4000);
        //bookATripPage.availableFlights().click();
        ArrayList<String> flightList = new ArrayList<>();
        int previousHashCode,currentHasCode;
        String previous,current;
        *//*Utilities.swipe(driver,bookATripPage.lastFlightElement());
        bookATripPage.lastFlightWebElement().click();*//*
        *//*do {
             *//**//*previousHashCode = driver.findElementsByXPath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']").hashCode();
            Utilities.flightOfferSwipe(driver);
             currentHasCode = driver.findElementsByXPath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']").hashCode();
             for(int i=0;i<driver.findElementsByXPath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']").size();i++){
                 System.out.println(driver.findElementsByXPath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']").get(i).getText());
             }
             System.out.println("Previous hascode:"+previousHashCode);
             System.out.println("Current Hashcode is"+currentHasCode);*//**//*
             int size=driver.findElementsByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='AMS'] ]").size();
              previous = driver.findElementsByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='AMS'] ]").get(0).getText().toString();
             Utilities.flightOfferSwipe(driver);
              current = driver.findElementsByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='AMS'] ]").get(0).getText().toString();
            driver.findElementsByXPath("//*[@class='UIView' and @width>0 and @height>0 and ./*[@text='AMS'] ]").
              System.out.println("Previous is:"+previous);
              System.out.println("Current is:"+current);
        }while(!(previous.equalsIgnoreCase(current)));*//*

        //System.out.println("Hashcode is"+size);
    *//*    for(int i=0;i<size;i++){
            flightList.add(driver.findElementsByXPath("//*[@class='CoreAppRedesign.FlightInfoCardViewTableViewCell']").get(i).getText());

        }*//*
    *//*compareList
*//*
        List<IOSElement> selectedElements = new ArrayList<>();

    do{
        List<IOSElement> elements=driver.findElements(By.xpath("//*[@accessibilityIdentifier='flight_departure_time']"));
        for(int i=0;i<elements.size();i++){
            //System.out.println("List of elements are:"+elements.get(i).getText());
            //selectedElements.add(elements.get(i));
            selectedElements.addAll(elements);
        }

        Utilities.swipe(driver,bookATripPage.lastFlightElement());

    }while(!(driver.findElements(By.xpath("//*[@accessibilityIdentifier='flight_last_element']")).size()>0));
    for(int i=0;i<selectedElements.size();i++)
    System.out.println("Total flight elements are"+selectedElements.get(i).getText());


    }*/



}
