package Java;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.*;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileManager {
    RandomNumberGenerator rng;
    ArrayList<CountryData> countryData;

    String fileName = "PersonalData.json";
    String directoryPath = "C:\\GeneratorData";
    String savePath = "C:\\GeneratorData\\output";

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

    public boolean writeWorkersToCSV(String country, int amountToGenerate) {

        String csvString = "surname,name,city,street,housenumber,role,zipcode,birthdate,salary\n";
        CountryData cData = countryData.stream().filter(n -> n.getCountry().equals(country)).findFirst().orElse(null);
        for (int i = 0; i < amountToGenerate; i++) {
            csvString += rng.getRandomSurName(cData) + ",";
            csvString += rng.getRandomName(cData) + ",";
            csvString += rng.getRandomCity(cData) + ",";
            csvString += rng.getRandomStreet(cData) + ",";
            csvString += rng.generateHouseNumber() + ",";
            csvString += rng.getRandomRole(cData) + ",";
            csvString += rng.generateZipCode() + ",";
            csvString += rng.generatesBirthdate() + ",";
            csvString += rng.generateSalary();
            csvString += "\n";
        }

        // save csv
        Path path = Path.of(savePath + "-" + country + "-" + amountToGenerate + ".csv");
        try {
            new File(directoryPath).mkdirs();
            Path csvFile = Files.createFile(path);   
            Files.writeString(csvFile, csvString, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            return true;
        } catch (IOException e) {
            // TODO: handle exception
            return false;
        }
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

        // DEBUG - REMOVE BEFORE LAUNCH
        // writeWorkersToCSV("Deutschland", 15);
    }

    String ReadFile() {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        s.close();

        return result;
    }
}
