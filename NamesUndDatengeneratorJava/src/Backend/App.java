package Backend;

import java.util.ArrayList;

public class App {

    // the ArrayList holding the CompanyWorker Objects
    ArrayList<CompanyWorker> companyWorkers;
    ArrayList<String> selectedCountries;

    static FileManager fileManager;

    public static void main(String[] args) throws Exception {
        fileManager = new FileManager();
        // var test = fileManager.getCountryNames();
    }

    void generateList(String country, int amount) {
        fileManager.writeWorkersToCSV(country, amount);
    } 

    void add(CompanyWorker c) {
        // add a CompanyWorker Object to the ArrayList
        companyWorkers.add(c);
    }
}
