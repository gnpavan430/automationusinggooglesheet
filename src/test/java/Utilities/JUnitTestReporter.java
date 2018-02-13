package Utilities;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import setup.NewSetup;
import setup.Setup;
import setup.Utilities;

import java.net.MalformedURLException;
import java.util.Date;

import static setup.Setup.driver;
import static setup.Setup.initializeDriver;

public class JUnitTestReporter extends NewSetup {




    @Rule
    public TestRule junitWatcher = new TestWatcher() {


        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println("Test passed");
            System.out.println("Passed Screenshot name is"+"PassedScreenshot"+Math.random());
            Utilities.captureScreenshot(driver,"PassedScreenshot"+Math.random());

            System.out.println(description.getDisplayName() + " "
                    + "Test Passed!");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Test failed");
            Date date = new Date();
            System.out.println("Failed Screenshot name is"+"FailedScreenshot"+Math.random());

            Utilities.captureScreenshot(driver,"FailedScreenshot"+Math.random());


            System.out.println(description.getDisplayName() + " "
                    + e.getClass().getSimpleName());
        }
    };
}