package Utilities;

//import com.google.gson.JsonObject;
import org.json.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtilities {
    static StringBuffer totalText=null;
    //File file = new File("C:\\Users\\X085271\\Desktop\\New folder (5)\\KL681_flightstatus Response.txt");


    public static void main(String args[]) throws IOException {
        file();

    }

    /*FileReader reader = new FileReader("C:\\Users\\X085271\\Desktop\\New folder (5)\\KL681_flightstatus Response.txt");
    BufferedReader bufferedReader = new BufferedReader(reader);*/
 public static void file() throws IOException {
     int contentLength = 0;
     FileReader reader = new FileReader("C:\\Users\\X085271\\Desktop\\New folder (5)\\kl1134flightstatus.txt");
     BufferedReader bufferedReader = new BufferedReader(reader);
     String line;
      /*  while((line=bufferedReader.readLine())!=null){
            //totalText.append(line);
            System.out.println("Before replacing content");
            System.out.println(line);

        }*/

     Path path = Paths.get("C:\\Users\\X085271\\Desktop\\New folder (5)\\KL887flightStatuResponse.txt");
     Charset charset = StandardCharsets.UTF_8;

     String content = new String(Files.readAllBytes(path), charset);
     //content = content.replaceAll("EARLY_DEPARTURE", "INTRANSIT");
     //content = content.replaceAll("\"latestPublished\":\"2018-02-01T20:44:00","\"latestPublished\":\"2018-02-01T20:24:00");
     Files.write(path, content.getBytes(charset));
     while((line=bufferedReader.readLine())!=null){
         //totalText.append(line);
         // System.out.println("After replacing content");
         //System.out.println(content);
         if(line.contains("Content-Length:")){
             /*System.out.println("Content length line is"+line);
             System.out.println(line.substring(16,20));*/
             contentLength= Integer.parseInt(line.substring(16,20));
         }

     }
     //System.out.println("Value of content length is"+contentLength);


     String answer = content.substring(content.indexOf("{"),content.lastIndexOf("}"));
     /*System.out.println("Extracted content is--------------------------------------------");
     System.out.println(answer);*/
     String json = answer+"}";
     JSONObject obj = new JSONObject(json);
     JSONArray jsonArray = obj.getJSONArray("flightLegs");
     JSONObject obj2 = jsonArray.getJSONObject(0);
     String value = obj2.getString("publishedStatus");
     //System.out.println("Status of flight is"+value);
     String updateStatus = "DELAYED_DEPARTURE";
     //System.out.println("Count:"+updateStatus.length());
     int diff = updateStatus.length()-value.length();
    // System.out.println("Difference:"+diff);
     int updatedContentLength=contentLength+diff;
     content = content.replaceAll(value,updateStatus);
     //System.out.println("Regex is"+"Content-Length: "+contentLength);
     String oldContentLength="Content-Length: "+contentLength;
     String newContentLength="Content-Length: "+updatedContentLength;
     //System.out.println("Comparison value of strings is"+oldContentLength.compareTo(newContentLength));
     content = content.replaceAll(oldContentLength,newContentLength);



     //content = content.replaceAll("\"Content-Length: \"+contentLength","\"Content-Length: \"+updatedContentLength");
     content = content.replaceAll("Content-Length: 1506","Content-Length: 1510");
     content = content.replaceAll("\"status\":\"S\"","\"status\":\"StatusValue\"");
     Files.write(path, content.getBytes(charset));







 }
 public String pubilshStatus() throws IOException {
     Path path = Paths.get("C:\\Users\\X085271\\Desktop\\New folder (5)\\KL887flightStatuResponse.txt");
     Charset charset = StandardCharsets.UTF_8;

     String content = new String(Files.readAllBytes(path), charset);
     String answer = content.substring(content.indexOf("{"),content.lastIndexOf("}"));
     /*System.out.println("Extracted content is--------------------------------------------");
     System.out.println(answer);*/
     String json = answer+"}";
     JSONObject obj = new JSONObject(json);
     JSONArray jsonArray = obj.getJSONArray("flightLegs");
     JSONObject obj2 = jsonArray.getJSONObject(0);
     String value = obj2.getString("publishedStatus");
     return value;


 }
 public void flightStatusChange(String previousFlightStatus,String newFlightStatus) throws IOException {
     int contentLength = 0;
     int diff = newFlightStatus.length()-previousFlightStatus.length();
     Path path = Paths.get("C:\\Users\\X085271\\Desktop\\New folder (5)\\KL887flightStatuResponse.txt");
     Charset charset = StandardCharsets.UTF_8;

     String content = new String(Files.readAllBytes(path), charset);
     FileReader reader = new FileReader("C:\\Users\\X085271\\Desktop\\New folder (5)\\kl1134flightstatus.txt");
     BufferedReader bufferedReader = new BufferedReader(reader);
     String line;
     while((line=bufferedReader.readLine())!=null){
         //totalText.append(line);
         // System.out.println("After replacing content");
         //System.out.println(content);
         if(line.contains("Content-Length:")){
             /*System.out.println("Content length line is"+line);
             System.out.println(line.substring(16,20));*/
             contentLength= Integer.parseInt(line.substring(16,20));
         }

     }
     int updatedContentLength=contentLength+diff;
     String oldContentLength="Content-Length: "+contentLength;
     String newContentLength="Content-Length: "+updatedContentLength;
     String previousStatus = "\"publishedStatus\":"+"\"" +previousFlightStatus + "\"";

     String newStatus = "\"publishedStatus\":"+"\"" + newFlightStatus + "\"";
     System.out.println("Previous status is"+previousStatus);
     System.out.println("New Status is"+newStatus);
     content = content.replaceAll(oldContentLength,newContentLength);
     content = content.replaceAll(previousStatus,newStatus);
     Files.write(path, content.getBytes(charset));








 }

}
