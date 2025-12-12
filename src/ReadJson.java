import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class ReadJson {

    public int idNum;

    public static void main(String args[]) throws ParseException {

        ReadJson readingIsWhat = new ReadJson(5);

    }

    public ReadJson(int pNum){
        try {
            pull(pNum);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public  void pull(int idNum) throws ParseException {
        String output = "abc";
        String totalJson = "";
        try {

            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + idNum + "/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            //if you get the error 403, uncomment line of code below
            //conn.setRequestProperty("User-Agent", "Mozilla/5.0"); // Add User-Agent


            if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                totalJson += output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) parser.parse(totalJson);

        try {

            String name = (String)jsonObject.get("name");
            long idNumber = (long)jsonObject.get("id");

            System.out.println();

        }

        catch (Exception e) {
            e.printStackTrace();
        }


//

    }
}


