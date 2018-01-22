package testcases;

import org.junit.Test;
import org.openqa.selenium.By;
import pageobjects.AddABookingPage;
import pageobjects.HomePage;
import pageobjects.MyTripsPage;
import setup.GetLogs;
import setup.Quickstart;
import setup.Setup;
import setup.Utilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddABookingTest extends Setup {
    public static ArrayList<String> data=new ArrayList<>();

    String goodNetwork="Good Network";
    String badNetwork="Bad Network";
    String edgeNetwork="Edge Network";

    public void addABooking(String network) throws InterruptedException, IOException {
        //result.clear();
        data.clear();
        Quickstart quickstart = new Quickstart();
        HomePage homePage=new HomePage(driver);
        MyTripsPage myTripsPage=new MyTripsPage(driver);
        Utilities utilities = new Utilities(driver);
        AddABookingPage addABookingPage = new AddABookingPage(driver);
        GetLogs getLogs=new GetLogs();
        homePage.myTrips().click();
        Thread.sleep(4000);
        driver.executeScript("client:client.swipe(\"Down\", 400, 500)");

        if(isElementPresent(By.xpath("//*[@text='Add a booking']"))){
            System.out.println("inside if");
            myTripsPage.addABooking().click();
        }
        else if(myTripsPage.addABookingActionButton().isDisplayed()){
            myTripsPage.addABookingActionButton().click();
        }
        addABookingPage.bookingCode().sendKeys("V4RVWU");
        addABookingPage.lastName().sendKeys("SENARD");
        myTripsPage.setBookingCode("V4RVWU");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        getLogs.startLogs();

        addABookingPage.findYourBookingButton().click();
        Date date = new Date();
        System.out.println("Just after clicking the add a booking button"+dateFormat.format(date));
        Utilities.waitForElement(driver,myTripsPage.title());
        Date date1 = new Date();
        System.out.println("After adding booking date is"+date1);
        Utilities.waitForElement(driver,myTripsPage.bookingCode());

        System.out.println("After booking is added"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        long value= TimeUnit.MILLISECONDS.toSeconds(diff);
        //double value = Utilities.timeFormatter(diff);
        getLogs.stopLogs();
        data=getLogs.readData();
        ArrayList<String>result=new ArrayList<>();

        for(int i=0;i<data.size();i++){
            if((data.get(i).contains("GET 'https://api.klm.com/travel/reservations/?bookingCode="))&(data.get(i).contains("AFNetworkActivityLogger"))){
                result.add(data.get(i));

            }
          /*  String re1=".*?";	// Non-greedy match on filler
            String re2="(200 'https:\\/\\/api\\.klm\\.com\\/travel\\/reservations\\/((?:[a-z][a-z]*[0-9]+[a-z0-9]*))\\/push-subscription-preference/')";	// Single Quote String 1

            Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
            Matcher m = p.matcher(data.get(i));
            if (m.find())
            {
                String strng1=m.group(1);
                //System.out.print("("+strng1.toString()+")"+"\n");
                if(data.get(i).contains("AFNetworkActivityLogger")){
                    result.add(data.get(i));
                }

            }*/
          if(data.get(i).contains("200 'https://api.klm.com/travel/reservations/?bookingCode=")&(data.get(i).contains("AFNetworkActivityLogger"))){
              result.add(data.get(i));
          }

        }
        System.out.println("Result Data is"+result);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for adding a booking"+value);
        long startResponseTime=Utilities.responseTime(result.get(0));
        long endResponseTime=Utilities.responseTime(result.get(1));
        long responseTime=endResponseTime-startResponseTime;
        long appTime=value-responseTime;
        Date timeStamp= new Date();
        //result.clear();
        System.out.println("After clearing Result data is"+result);

        quickstart.appendValuesAddABooking(network,timeStamp,value,appTime,responseTime);



    }
    @Test
    public void goodNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setWifi(driver);
        utilities.setNetwork(driver,utilities.getGoodNetwork());
        addABooking(goodNetwork);




    }

    @Test
    public void badNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setBadNetworkCondition(driver);
        utilities.setNetwork(driver,utilities.getBadNetwork());
        addABooking(badNetwork);



    }

    @Test
    public void edgeNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setEdgeNetwork(driver);
        utilities.setNetwork(driver,utilities.getEdgeNetwork());
        addABooking(edgeNetwork);

    }
    protected boolean isElementPresent(By by) {
        boolean isElement = false;
        try
        {
            if (driver.findElement(by) != null)
            {
                isElement = true;
                return isElement;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Element not found");
            isElement = false;
            return isElement;
        }
        return isElement;
    }

}
