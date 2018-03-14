package setup;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Quickstart {
    String valueInputOption = "USER_ENTERED"; // TODO: Update placeholder value
    /** Application name. */
    private static final String APPLICATION_NAME =
            "Automation";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/sheets.googleapis.com-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =Quickstart.class.getResourceAsStream("/client_secret.json");

        GoogleClientSecrets clientSecrets =GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .setApprovalPrompt("none")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("gnpavan430@gmail.com");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Sheets API client service.
     * @return an authorized Sheets API client service
     * @throws IOException
     */
    public static Sheets getSheetsService() throws IOException {

        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        Quickstart quickstart = new Quickstart();
        quickstart.dataFromSheet();

     /*   if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
               // System.out.printf("Printing the data"+"%s, %s\n", row.get(0), row.get(4));
                System.out.println("Values are"+values.size());
                System.out.println("Login username is"+row.get(0).toString());

            }
        }*/
    }
    public List<List<Object>> dataFromSheet() throws IOException {
        Sheets service = getSheetsService();
        /*Spreadsheet spreadsheet= new Spreadsheet();
        service.spreadsheets().create(spreadsheet).execute();*/




        // Prints the names and majors of students in a sample spreadsheet:
        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
        //String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        String spreadsheetId = "1QI--5mfw5IP0vxCYWW5yHwW7KhX3XJrtcgdt08gltZY";
        //String range = "Class Data!A2:E";
        String range = "A2:E";
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();




        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                // System.out.printf("Printing the data"+"%s, %s\n", row.get(0), row.get(4));
                System.out.println("Values are"+values.get(0).get(0));
                System.out.println("Login username is"+row.get(0).toString());

            }
        }
        return values;


    }
    public void appendValues(String network, Date timeStamp, long loginTime, long logoutTime, long responseTimeValue) throws IOException {
        String range=null;
        Sheets service = getSheetsService();
        String spreadsheetId = "1Fap5e5uZvUeC1NjJJUr70ecTDHS7VcnS9iSphtZPxZE";
        long time=timeStamp.getTime();
        String timeString=timeStamp.toString();
        if(network.equalsIgnoreCase("Good Network")){
             range = "A2:D";
        }else if(network.equalsIgnoreCase("Bad Network")){
            range = "F2:I";
        }
        else if(network.equalsIgnoreCase("Edge Network")){
            range = "K2:N";
        }



        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        // Cell values ...
                       timeString,loginTime,logoutTime,responseTimeValue

                )
                // Additional rows ...
        );
        ValueRange body = new ValueRange().setValues(values);

        AppendValuesResponse result = service.spreadsheets().values().append(spreadsheetId, range, body)
                        .setValueInputOption(valueInputOption)
                        .execute();

    }
    //Method for adding values related to Add a Booking in Google sheet
    public void appendValuesAddABooking(String network, Date timeStamp, long totalTime, long appTime, long responseTimeValue) throws IOException {
        String range=null;
        Sheets service = getSheetsService();
        String spreadsheetId = "1HNxa-JWRlMMsgJBEIAUWpAWcVLFUTM-a4_JFoG0uHbU";
        long time=timeStamp.getTime();
        String timeString=timeStamp.toString();
        if(network.equalsIgnoreCase("Good Network")){
            range = "A2:D";
        }else if(network.equalsIgnoreCase("Bad Network")){
            range = "F2:I";
        }
        else if(network.equalsIgnoreCase("Edge Network")){
            range = "K2:N";
        }



        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        // Cell values ...
                        timeString,totalTime,appTime,responseTimeValue

                )
                // Additional rows ...
        );
        ValueRange body = new ValueRange().setValues(values);

        AppendValuesResponse result = service.spreadsheets().values().append(spreadsheetId, range, body)
                .setValueInputOption(valueInputOption)
                .execute();

    }

    //Adding Book a Trip time stamps in Google Sheet
    public void appendValuesBookATrip(String network, Date timeStamp, long totalTime, long appTime, long responseTimeValue) throws IOException {
        String range=null;
        Sheets service = getSheetsService();
        String spreadsheetId = "1F-fH-8qDgaT4z4wQWgkJSFajpx8V8VdRQEYtjhKtB8E";
        long time=timeStamp.getTime();
        String timeString=timeStamp.toString();
        if(network.equalsIgnoreCase("Good Network")){
            range = "A2:D";
        }else if(network.equalsIgnoreCase("Bad Network")){
            range = "F2:I";
        }
        else if(network.equalsIgnoreCase("Edge Network")){
            range = "K2:N";
        }



        List<List<Object>> values = Arrays.asList(
                Arrays.asList(
                        // Cell values ...
                        timeString,totalTime,appTime,responseTimeValue

                )
                // Additional rows ...
        );
        ValueRange body = new ValueRange().setValues(values);

        AppendValuesResponse result = service.spreadsheets().values().append(spreadsheetId, range, body)
                .setValueInputOption(valueInputOption)
                .execute();

    }



}