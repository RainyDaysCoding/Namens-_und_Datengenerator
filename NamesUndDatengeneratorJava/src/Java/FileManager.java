package Java;

import java.util.ArrayList;

import org.json.*;
import java.io.InputStream;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileManager {
    RandomNumberGenerator rng;
    ArrayList<CountryData> countryData;

    String fileName = "PersonalData.json";
    String savePath = "C:\\GeneratorData\\Output";

    public FileManager() {
        rng = new RandomNumberGenerator();
        countryData = new ArrayList<CountryData>();
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

    ArrayList<String> ConvertJSONArrayToArrayList(JSONArray jsonArray) {
        ArrayList<String> list = new ArrayList<String>();
        if (jsonArray != null) {
            int len = jsonArray.length();
            for (int i=0;i<len;i++) { 
                list.add(jsonArray.get(i).toString());
            } 
        }
        return list;
    }

    void loadJSONData() {
        String jsonString = ReadFile();
        JSONObject obj = new JSONObject(jsonString);

        for (String country : obj.keySet()) {
            ArrayList<String> surnames = ConvertJSONArrayToArrayList(new JSONArray(new JSONObject(obj.get(country).toString()).get("surNames").toString()));
            ArrayList<String> names = ConvertJSONArrayToArrayList(new JSONArray(new JSONObject(obj.get(country).toString()).get("names").toString()));
            ArrayList<String> roles = ConvertJSONArrayToArrayList(new JSONArray(new JSONObject(obj.get(country).toString()).get("roles").toString()));
            ArrayList<String> cities = ConvertJSONArrayToArrayList(new JSONArray(new JSONObject(obj.get(country).toString()).get("cities").toString()));
            ArrayList<String> streets = ConvertJSONArrayToArrayList(new JSONArray(new JSONObject(obj.get(country).toString()).get("streets").toString()));
            countryData.add(new CountryData(country, surnames, names, roles, cities, streets));
        }
    }

    String ReadFile() {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        s.close();

        return result;
    }
}
