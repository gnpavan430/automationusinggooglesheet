package setup;

import java.io.IOException;

public class CheckLogs {
    public static void main(String args[]) throws InterruptedException, IOException {
       String log = "CoreAppRedesign_iPhone_Development(CocoaLumberjack)[2021] <Notice>: 200 'https://api.klm.com/travel/customers/1035428423/memberships/flying-blue/transactions?start-date=2017-01-10&end-date=2018-01-10' [8.7417 s]: ";
       String pattern=".";
       System.out.println(log.replaceAll(pattern,log));

    }
}
