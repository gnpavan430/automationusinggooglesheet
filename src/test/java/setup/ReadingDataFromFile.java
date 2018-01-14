package setup;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

public class ReadingDataFromFile {
    public static void main(String args[]) throws FileNotFoundException {
        readData();

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
