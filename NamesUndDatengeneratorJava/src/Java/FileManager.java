package Java;
import java.util.ArrayList;
import java.util.Objects;

import org.json.*;
import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;             // Import the Scanner class to read text files

public class FileManager {
    RandomNumberGenerator rng;
    ArrayList<CountryData> countryData;

    String dataPath = "./Data/PersonalData";
    String savePath = "C:\\GeneratorData\\Output";

    public FileManager() {
        rng = new RandomNumberGenerator();
        loadJSONData();
    }

    public ArrayList<String> getCountryNames() {
        
        ArrayList<String> countryNames = new ArrayList<>();
        
        for (CountryData country : countryData) {
            countryNames.add(country.getCountry());
        }

        return countryNames;
    }

    public void getWorkerFromFile(String country) {
        // return complete companyWorker
    }

    public boolean writeWorkersToCSV(ArrayList<CompanyWorker> workers) {
        return true;
    }

    void loadJSONData() {
        String jsonString = ReadFile();
        JSONObject obj = new JSONObject(jsonString);

        String debug = obj.toString();
        System.out.println(debug);

        // String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        // JSONArray arr = obj.getJSONArray("posts"); // notice that `"posts": [...]`
        // for (int i = 0; i < arr.length(); i++)
        // {
        //     String post_id = arr.getJSONObject(i).getString("post_id");
        // }
    }

    String ReadFile() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("PersonalData.json");
        
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        s.close();

        return result;
    }
}
