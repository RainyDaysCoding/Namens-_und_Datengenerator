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

        for (String country : obj.keySet()) {
            System.out.println(country);
        }

        // countryData.add(new CountryData(jsonString, getCountryNames(),
        // getCountryNames(), getCountryNames(), getCountryNames(), getCountryNames()))
    }

    String ReadFile() {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        s.close();

        return result;
    }
}
