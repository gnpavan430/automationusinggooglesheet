package setup;

import java.io.*;
import java.util.ArrayList;

public class GetLogs {
    public static ArrayList<String> data=new ArrayList<>();

    public static void main(String args[]) throws FileNotFoundException {
        GetLogs getLogs = new GetLogs();
        data=getLogs.readData();
        System.out.println("Size of data is"+data.size());

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
    public  ArrayList<String> readData() throws FileNotFoundException {
        //ArrayList data=new ArrayList<>();

        File temp = new File("D:\\Automation\\consolelogs.txt");
        FileReader reader = new FileReader("D:\\Automation\\consolelogs.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        //CommandLine command = new CommandLine()

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                if((line.contains("https://api") ||(line.contains("https://www.klm.com")) )){
                    data.add(line);
                   /* if(line.contains("PUT 'https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/")){
                        data.add(line);
                    }
                    if(line.contains("200 'https://api.klm.com/travel/customers/1035428423/memberships/flying-blue/transactions?start-date=")){
                        data.add(line);
                    }*/

                    //System.out.println("First few characters:"+line.substring(0,16));
                 /*   if(line.contains("PUT 'https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/66B1CF4A-72C1-47E8-B348-7CAC23AE2CFD'")){
                        System.out.println("Starting log time stamp is"+line.substring(0,16));
                    }
                    if(line.contains("https://api.klm.com/travel/customers/1035428423/notification-subscriptions/installed-apps/66B1CF4A-72C1-47E8-B348-7CAC23AE2CFD")){
                        System.out.println("Ending log time stamp is"+line.substring(0,16));
                    }*/

                    //System.out.println(line);

                }

            }
            reader.close();
            System.out.println(data);
            /*System.out.println("First element is"+data.get(0));
            System.out.println("Last element is"+data.get(data.size()-1));
            System.out.println("Data size is"+data.size());*/
           /* long startTime= Utilities.responseTime(data.get(0));
            long endTime = Utilities.responseTime(data.get(data.size()-1));
            long timedifference = endTime-startTime;
            System.out.println("Time differnce is"+timedifference);*/

            /*RandomAccessFile raf = new RandomAccessFile(temp, "rw");
            raf.setLength(0);*/
            FileWriter fw = new FileWriter("D:\\Automation\\consolelogs.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.write("");
            pw.flush();
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;



    }

}
