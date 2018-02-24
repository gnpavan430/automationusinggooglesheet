package testcases;

import setup.NewSetup;

public class Test extends NewSetup {
    @org.testng.annotations.Test
    public void test() throws InterruptedException {
       // driver.executeScript("client:client.swipeWhileNotFound(\"Down\", 400, 2000, \"NATIVE\", elementToFind, 0, 1000, 5, true)");
        Thread.sleep(4000);
        //"invokeMethod:'{"selector":"currentLogFileData","arguments":[]}'")
        driver.executeScript("client:client.runNativeAPICall(\"NATIVE\", \"xpath=//*[@class='CoreAppRedesign.CustomNavigationBar']\", 0," +"\"invokeMethod:'{\"selector\":\"currentLogFileContents\",\"arguments\":[]}'\")");




    }



}
