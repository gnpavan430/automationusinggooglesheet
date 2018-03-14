package testcases;//package <set your test package>;

//import org.junit.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.FlyingBlue;
import pageobjects.LoginPage;
import pageobjects.Profile;
import setup.*;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class LoginTest extends Setup {
   public static ArrayList<String>data=new ArrayList<>();
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    String goodNetwork="Good Network";
    String badNetwork="Bad Network";
    String edgeNetwork="Edge Network";
   public static String network;
    private List<Object> list;

   // private Sample sample;
    //private IOSDriver driver;
   // protected IOSDriver<IOSElement> driver = setUp();

   // DesiredCapabilities dc = new DesiredCapabilities();
    //LoginPage loginPage=new LoginPage();



    public LoginTest(List<Object> list){
        this.list=list;

    }

    /*  @Before
      public void setUp() throws MalformedURLException {
          dc.setCapability("reportDirectory", reportDirectory);
          dc.setCapability("reportFormat", reportFormat);
          dc.setCapability("testName", testName);
          dc.setCapability(MobileCapabilityType.UDID, "67e48a029ef2918109bbd2011bd3c6b4497f2eae");
          dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.klm.mobile.iphone.MCAR-iPhone");
          driver = new IOSDriver<IOSElement>(new URL("http://localhost:4723/wd/hub"), dc);
          driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
      }
  */
    /*@Test
    public void testUntitled() {
        driver.executeScript("client:client.setDevice(\"ios_app:IMO's iPhone 5S Pavan\")");
       // driver.executeScript("client:client.launch(\"com.klm.mobile.iphone.MCAR-iPhone\")");
//        driver.manage().timeouts().implicitlyWait(6000,TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")));
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        loginPage.getFlyingBlue().click();
       *//* LoginPage.getFlyingBlue().click();
        LoginPage.getLogin().click();
        //driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Enrollment']]")).click();
        LoginPage.getUsername().clear();
        LoginPage.getUsername().sendKeys("1121711790");
        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeTextField']")).clear();
       // driver.getKeyboard().sendKeys("1121711790");
        LoginPage.getPassword().click();
        LoginPage.getPassword().sendKeys("1234");

        //driver.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeSecureTextField']")).click();
        //driver.getKeyboard().sendKeys("1234");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println("Before clicking the button"+dateFormat.format(date)); //2016/11/16 12:08:43
        LoginPage.getLoginButton().click();
        //driver.findElement(By.xpath("//*[@class='UIAButton' and ./preceding-sibling::*[@text='Log in'] and ./parent::*[@class='UIAView']]")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@value='1121711790' and @XCElementType='XCUIElementTypeTextView']")));
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        System.out.println("Time taken for login"+diff);*//*
       *//* driver.findElement(By.xpath("//*[@class='UIAView' and ./*[@text='Btm_Normal_Profile']]")).click();
        driver.findElement(By.xpath("//*[@class='UIAButton']")).click();
        driver.findElement(By.xpath("//*[@text='Log out' and @class='UIAButton']")).click();
        String text=driver.findElement(By.xpath("//*[@class='UIAButton']")).getText();
        System.out.println("Text of button is"+text);*//*



    }*/
    @Test
     public void goodNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setWifi(driver);
        utilities.setNetwork(driver,utilities.getGoodNetwork());
        network=goodNetwork;
        login(goodNetwork);





    }

    @Test
    public void badNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setBadNetworkCondition(driver);
        utilities.setNetwork(driver,utilities.getBadNetwork());
        network=badNetwork;
        login(badNetwork);




    }

    @Test
    public void edgeNetwork() throws IOException, InterruptedException {
        Utilities utilities = new Utilities(driver);
        //utilities.setEdgeNetwork(driver);
        utilities.setNetwork(driver,utilities.getEdgeNetwork());
        network=edgeNetwork;
        login(edgeNetwork);

    }
    @Parameterized.Parameters
    public static List<Object> data() throws IOException {
        Quickstart quickstart = new Quickstart();
        List<List<Object>> values = quickstart.dataFromSheet();
        System.out.println("Values from sheet are"+values);
        List<Object> list = new ArrayList<Object>();
        for(int i=0;i<values.size();i++){
            list.add(values.get(i));
        }

        //List<Object> list = values.get(0);
        System.out.println("Values in list are"+list);
        return list;

    }

    public void login(String network) throws IOException, InterruptedException {
        data.clear();
        Quickstart quickstart = new Quickstart();
        FlyingBlue flyingBlue = new FlyingBlue(driver);
        LoginPage loginPage = new LoginPage(driver);
        Profile profile=new Profile(driver);
        flyingBlue.flyingBlue().click();
        GetLogs getLogs=new GetLogs();
        QuickStartDrive quickStartDrive = new QuickStartDrive();
        //data=getLogs.readData();
       /* Quickstart quickstart = new Quickstart();
        List<List<Object>> values = quickstart.dataFromSheet();
        List<Object> list = values.get(0);*/


//        Utilities.waitForElement(driver,loginPage.username());
        System.out.println("User name is"+list.get(0));

        loginPage.login().click();
        loginPage.username().clear();
        DateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date8 = new Date();

        System.out.println("Before entering text"+dateFormat1.format(date8)); //2016/11/16 12:08:43
        loginPage.username().sendKeys(list.get(0).toString());
        Date date9 = new Date();

        System.out.println("After entering text"+dateFormat1.format(date9));
        loginPage.password().sendKeys(list.get(1).toString());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //This is the method that will start taking the logs
        try {
            getLogs.startLogs();
            //startLogs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        loginPage.loginButton().click();
        Date date = new Date();

        System.out.println("Before clicking the login button"+dateFormat.format(date)); //2016/11/16 12:08:43


       Utilities.waitForElement(driver,flyingBlue.getFlyingBlueNumberText());
        //new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(flyingBlue.getFlyingBlueNumberText()));

//        flyingBlue.flyingBlueNumberText().click();
        Date date1 = new Date();
        System.out.println("After screen is loaded"+dateFormat.format(date1));
        long diff = date1.getTime()-date.getTime();
        long value=TimeUnit.MILLISECONDS.toSeconds(diff);
        //double value = Utilities.timeFormatter(diff);
        System.out.println("Time in Seconds"+diff);
        System.out.println("Time taken for login"+value);

        profile.profileButton().click();
        profile.logoutButton().click();
        Date date2 = new Date();
        System.out.println("Before clicking logout button"+dateFormat.format(date2));
        profile.alertTextLogout().click();
        Utilities.waitForElement(driver,profile.loginButtonText());
        profile.loginButton().click();
        Date date3 = new Date();
        System.out.println("After logout"+dateFormat.format(date3));
        //Utilities.waitForElement(driver,loginPage.loginScreenHeaderText());


        long diff1 = date3.getTime()-date2.getTime();
        System.out.println("Difference 1 value is"+diff1);
        long value1=TimeUnit.MILLISECONDS.toSeconds(diff1);
        //double value1 = Utilities.timeFormatter(diff1);
        System.out.println("Time in Seconds"+diff1);
        System.out.println("Time taken for logout"+value1);
        //Method to stop the logs
        getLogs.stopLogs();
        //stopLogs();
        //readData();
       data=getLogs.readData();
       ArrayList<String> result = new ArrayList<String>();
       System.out.println("Total data is"+data);
       for(int i=0;i<data.size();i++){
           if((data.get(i).contains("POST 'https://www.klm.com/oauthcust/oauth/token'"))&(data.get(i).contains("CocoaLumberjack"))){
               result.add(data.get(i));

           }
           if((data.get(i).contains("200 'https://api.klm.com/travel/reservations/?historical=true' "))&(data.get(i).contains("CocoaLumberjack"))){
               result.add(data.get(i));
           }
       }
       System.out.println("Logs in result are"+result);


        long startResponseTime=Utilities.responseTime(result.get(0));
        long endResponseTime;
        if( (result.get(0).substring(7,9)).equalsIgnoreCase("11")&&(result.get(data.size()-1).substring(7,9)).equalsIgnoreCase("00")){
             endResponseTime=Utilities.responseTime(result.get(result.size()-1))+(12*3600);
        }
        else{
            System.out.println("last data is"+result.get(result.size()-2));
             endResponseTime=Utilities.responseTime(result.get(result.size()-2));
        }


        long responseTime=endResponseTime-startResponseTime;
        System.out.println("starting time stamp"+result.get(0).substring(7,15));
        System.out.println("Ending time"+result.get(result.size()-1).substring(7,15));
        System.out.println("Response time in seconds is"+responseTime);
        //double responseTimeValue=Utilities.timeFormatter(responseTime);

        Date timeStamp= new Date();

        quickstart.appendValues(network,timeStamp,value,responseTime,value1);









    }
    public void startLogs() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("C:\\Users\\X085271\\Desktop\\app.bat");
        Thread.sleep(30000);
    }
    public void stopLogs() throws IOException, InterruptedException {
        Thread.sleep(60000);
        Runtime.getRuntime().exec("taskkill /F /IM sdsiosloginfo.exe");
        Thread.sleep(30000);
    }
    public static void readData() throws FileNotFoundException {
        //ArrayList data=new ArrayList<>();

        File temp = new File("D:\\Automation\\consolelogs.txt");
        FileReader reader = new FileReader("D:\\Automation\\consolelogs.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        //CommandLine command = new CommandLine()

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                if(line.contains("https://api")){
                    if((line.contains("PUT 'https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/")&(line.contains("AFNetworkActivityLogger")))){
                        data.add(line);
                    }
                     if((line.contains("200 'https://api.klm.com/travel/customers/1035428423/memberships/flying-blue/transactions?start-date="))&(line.contains("AFNetworkActivityLogger"))){
                        data.add(line);
                     }

                    //System.out.println("First few characters:"+line.substring(0,16));
                 /*   if(line.contains("PUT 'https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/66B1CF4A-72C1-47E8-B348-7CAC23AE2CFD'")){
                        System.out.println("Starting log time stamp is"+line.substring(0,16));
                    }
                    if(line.contains("https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/66B1CF4A-72C1-47E8-B348-7CAC23AE2CFD")){
                        System.out.println("Ending log time stamp is"+line.substring(0,16));
                    }*/

                // System.out.println(line);
                 //System.out.println(data);
                }

            }
             reader.close();
            System.out.println("First element is"+data.get(0));
            System.out.println("Last element is"+data.get(data.size()-1));
            System.out.println("Data size is"+data.size());
            System.out.println("Data is"+data);
           /* long startTime= Utilities.responseTime(data.get(0));
            long endTime = Utilities.responseTime(data.get(data.size()-1));
            long timedifference = endTime-startTime;
            System.out.println("Time differnce is"+timedifference);*/

            /*RandomAccessFile raf = new RandomAccessFile(temp, "rw");
            raf.setLength(0);*/
            FileWriter fw = new FileWriter("D:\\Automation\\consolelogs.txt");
            QuickStartDrive quickStartDrive = new QuickStartDrive();
            //quickStartDrive.fileUpload(network,new Date());
            PrintWriter pw = new PrintWriter(fw);
            pw.write("");
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}