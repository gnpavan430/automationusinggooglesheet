package pageobjects;

import Utilities.FileUtilities;
import org.apache.http.client.utils.DateUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice {
    public static void main(String args[]) throws ParseException, IOException {
      /*  Practice practice = new Practice();
        practice.changeDate(4);*/
        String destination = System.getProperty("user.dir") + "/Screenshots/"+"screenshotName"+"dateName"+".jpeg";
        System.out.println("Path is"+destination);

    }
    public void changeDate(int hours) throws ParseException, IOException {
        FileUtilities fileUtilities = new FileUtilities();
        //String flightTime = "2018-02-19T20:55:00.000+01:00";
        String flightTime = fileUtilities.latestPublishedDepartureTime();
        String hourPart = flightTime.substring(0,10);
        String minutesPart = flightTime.substring(11,19);
        String extraPart= flightTime.substring(19,29);
        String newFlightTime = hourPart+" "+minutesPart;
        System.out.println("New flight time is"+newFlightTime);
        System.out.println("Hour part is"+hourPart+"Minutes part is"+minutesPart);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date newDate =org.apache.commons.lang3.time.DateUtils.addDays(new Date(),2);
        String newDate2 = String.valueOf(newDate);
        //System.out.println("Substring"+newDate2.substring(8,9));
        if(newDate2.substring(8,9).equalsIgnoreCase("0")){
            System.out.println("New value of date is"+newDate2.substring(9,10));
        }
        else{
            System.out.println("New value of date is"+newDate2.substring(8,10));
        }
        /*System.out.println("Substring value of date is"+newDate2.substring(8,10));
        System.out.println("New date from current date is"+newDate);*/


        Date date =formatter.parse(newFlightTime);
        System.out.println("Date is"+date);
        Date newDate1 =org.apache.commons.lang3.time.DateUtils.addHours(date,hours);
        System.out.println("New date is"+newDate1);
        String newDateString = formatter.format(newDate1)+extraPart;
        System.out.println("New Date string is"+newDateString);
        String newFramedString=newDateString.substring(0,10)+"T"+newDateString.substring(11,19)+newDateString.substring(19,29);
        System.out.println("New Framed String is"+newFramedString);
        System.out.println(flightTime.compareTo(newFramedString));
        Path path = Paths.get("C:\\Users\\X085271\\Desktop\\New folder (5)\\kl1681flightstatusresponse.txt");
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);

        String oldLatestPublished = "\"latestPublished\":"+"\"" +fileUtilities.latestPublishedDepartureTime() + "\"";
        System.out.println("Old published value is"+oldLatestPublished);

        String newLatestPublished = "\"latestPublished\":"+"\"" +newFramedString + "\"";
        content = content.replaceAll(oldLatestPublished,newLatestPublished);
        Files.write(path, content.getBytes(charset));

    }
}
