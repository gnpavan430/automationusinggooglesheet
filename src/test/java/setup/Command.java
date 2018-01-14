package setup;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Command {
    private static Thread mainThread;
    public static void main(String args[]) throws IOException, InterruptedException {
        String command = "cmd /c start cmd.exe";
        Runtime.getRuntime().exec("C:\\Users\\X085271\\Desktop\\app.bat");
        Thread.sleep(4000);
        Runtime.getRuntime().exec("taskkill /F /IM sdsiosloginfo.exe");
        Thread.sleep(4000);
        readData();

        //Runtime.getRuntime().exec("taskkill /PID 16868");





        Thread.sleep(24000);


    }
    public static void readData() throws FileNotFoundException {
        File temp = new File("D:\\Automation\\consolelogs.txt");
        FileReader reader = new FileReader("D:\\Automation\\consolelogs.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        //CommandLine command = new CommandLine()

        String line;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                if(line.contains("https://api")){
                    System.out.println("First few characters:"+line.substring(0,16));

                    System.out.println(line);
                }

            }
            reader.close();
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



    }

}
