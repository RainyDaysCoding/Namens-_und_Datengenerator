package Test;

import Java.CountryData;
import Java.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    static CountryData countryData;

    @BeforeAll
    public static void init() {
        ArrayList<String> surName = new ArrayList<String>(
                Arrays.asList("Vorname1", "Vorname2", "Vorname3", "Vorname4"));
        ArrayList<String> names = new ArrayList<String>(Arrays.asList("Jonas", "Matheo", "Benni", "Penni"));
        ArrayList<String> roles = new ArrayList<String>(Arrays.asList("Körperklaus", "Fisi", "Lehrer", "Schühler"));
        ArrayList<String> cities = new ArrayList<String>(Arrays.asList("Berlin", "Dahlewitz", "Paris", "Rom"));
        ArrayList<String> streets = new ArrayList<String>(Arrays.asList("Straße1", "Straße2", "Straße3", "Straße4"));

        countryData = new CountryData("Deutschland", surName, names, roles, cities, streets);
    };

    @Test
    void generateRandomINTInRage() {
        // Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // Action
        int result = randomNumberGenerator.generateRandomINTInRage(10, 20);

        // Assert
        assertTrue(result < 21 && result > 9, "Fehler: Zahl liegt nicht zwischen 10 und 20");

    }

    @Test
    void generateZipCode() {
        // Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // Action
        int result = randomNumberGenerator.generateZipCode();

        // Assert
        assertTrue(result < 100000 && result > 9999, "Fehler: Zahl liegt nicht zwischen 10 und 20");

    }

    @Test
    void generatesBirthdate() {
        // Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // Action
        String result = randomNumberGenerator.generatesBirthdate();
        String[] resultSplit = result.split("\\.");
        int tag = Integer.parseInt(resultSplit[0]);
        int month = Integer.parseInt(resultSplit[1]);
        int year = Integer.parseInt(resultSplit[2]);

        // Assert
        assertEquals(result.length(), 10, "Fehler: das Datum ist nicht 10 zeichen lang");
        assertTrue(tag < 32 && tag > 0, "Fehler: Zahl liegt nicht zwischen 1 und 31");
        assertTrue(month < 13 && month > 0, "Fehler: Zahl liegt nicht zwischen 1 und 12");
        assertTrue(year > LocalDate.now().getYear() - 71 && year < LocalDate.now().getYear() - 15,
                "Fehler: ist nicht Zwischen 16 und 70 Jahre alt");

    }

    @Test
    void generateSalary() {
        // Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // Action
        int result = randomNumberGenerator.generateSalary();

        // Assert
        assertTrue(result < 10001 && result > 1499, "Fehler: Zahl liegt nicht zwischen 1500 und 10000");

    }

    @Test
    void generateHouseNumber() {
        // Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // Action
        String result = randomNumberGenerator.generateHouseNumber();
        String[] resultSplit = result.split(" ");
        int hausNumber = Integer.parseInt(resultSplit[0]);

        // Assert
        assertTrue(hausNumber < 101 && hausNumber > 0, "Fehler: Zahl liegt nicht zwischen 1 und 100");
        assertTrue(result.length() >= 2 || result.length() < 6, "Fehler: die ausgabe ist zu Kurtz oder zu Lang");
    }

    @Test
    void getRandomName() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String result = randomNumberGenerator.getRandomName(countryData);

        assertNotNull(result, "Fehler es wird Null zurückgegeben");
        assertTrue(result.length() > 0, "Fehler ausgabe ist zu Kurtz");

    }

    @Test
    void getRandomSurName() {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String result = randomNumberGenerator.getRandomName(countryData);

        assertNotNull(result, "Fehler es wird Null zurückgegeben");
        assertTrue(result.length() > 0, "Fehler ausgabe ist zu Kurtz");
    }

    @Test
    void getRandomRole() {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String result = randomNumberGenerator.getRandomRole(countryData);

        assertNotNull(result, "Fehler es wird Null zurückgegeben");
        assertTrue(result.length() > 0, "Fehler ausgabe ist zu Kurtz");

    }

    @Test
    void getRandomStreet() {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        String result = randomNumberGenerator.getRandomStreet(countryData);

        assertNotNull(result, "Fehler es wird Null zurückgegeben");
        assertTrue(result.length() > 0, "Fehler ausgabe ist zu Kurtz");

    }

}
