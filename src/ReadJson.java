import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Program for print data in JSON format.
public class ReadJson {

    public String[] thinkerNames;

    public readJson(int pNum){
        try {
            pull();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public  void pull() throws ParseException {
        String output = "abc";
        String totalJson = "";
        try {

            URL url = new URL("https://philosophyapi.pythonanywhere.com/api/philosophers/");
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

            JSONArray allThinkers = (JSONArray)jsonObject.get("results");

            int size = allThinkers.size();

            for (int i = 0; i < size; i++) {
                JSONObject thinker = (JSONObject)allThinkers.get(i);
                String name = (String) thinker.get("name");
                System.out.println(name);

                thinkerNames[i] = name;
            }

        }

        catch (Exception e) {
            e.printStackTrace();
        }


//

    }
}

void main() {
}


