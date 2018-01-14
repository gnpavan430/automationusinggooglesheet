package pageobjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HTTPURL {
    public static void main(String args[]) throws IOException {
        URL url = new URL("https://api.ute2.klm.com/travel/locations/airports");
        HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Content-Type","application/json");
       // httpURLConnection.setRequestProperty("Accept","application/hal+json;profile=com.afklm.reservation.v2");
        httpURLConnection.setRequestProperty("Authorization","Bearer 7faj75fvbvj329btyt4nykac");

        //int responseCode = httpURLConnection.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

    }
}
