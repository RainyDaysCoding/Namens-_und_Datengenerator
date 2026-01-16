package Test;
import Java.RandomNumberGenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;



public class RandomNumberGeneratorTest {
    
    @Test
    void generateRandomINTInRage(){
        //Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //Action
        int result = randomNumberGenerator.generateRandomINTInRage(10, 20);

        //Assert
        assertTrue(result < 21 && result > 9, "Fehler: Zahl liegt nicht zwischen 10 und 20");

    }

    @Test
    void generateZipCode(){
        //Arrang
         RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        
         //Action
        int result = randomNumberGenerator.generateZipCode();
        
        //Assert
        assertTrue(result < 100000 && result > 9999, "Fehler: Zahl liegt nicht zwischen 10 und 20");

    }
    @Test
    void generatesBirthdate(){
                //Arrang
         RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        
         //Action
        String result = randomNumberGenerator.generatesBirthdate();
        String[] resultSplit = result.split("."); 
        int tag = Integer.parseInt(resultSplit[0]);
        int month = Integer.parseInt(resultSplit[1]);
        int year = Integer.parseInt(resultSplit[2]);

        //Assert
        assertEquals(result.length(),10,"Fehler: das Datum ist nicht 10 zeichen lang");
        assertTrue( tag < 32 && tag > 0, "Fehler: Zahl liegt nicht zwischen 1 und 31");
        assertTrue( month < 13 && month > 0, "Fehler: Zahl liegt nicht zwischen 1 und 12");
        assertTrue( year < LocalDate.now().getYear()-71 && year > LocalDate.now().getYear()-15 , "Fehler: ist nicht Zwischen 16 und 70 Jahre alt");

    }
    @Test
    void generateSalary(){
        //Arrang
         RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        
         //Action
        int result = randomNumberGenerator.generateSalary();
        
        //Assert
        assertTrue(result < 10001 && result > 1499, "Fehler: Zahl liegt nicht zwischen 1500 und 10000");

    }
    @Test
    void generateHouseNumber(){
        //Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        
         //Action
        String result = randomNumberGenerator.generateHouseNumber();
        String[] resultSplit = result.split(" ");
        int hausNumber = Integer.parseInt(resultSplit[0]);
        
        //Assert
        assertTrue(hausNumber < 101 && hausNumber > 0, "Fehler: Zahl liegt nicht zwischen 1 und 100");
        assertTrue(result.length() >= 2 || result.length() < 6, "Fehler: die ausgabe ist zu Kurtz oder zu Lang");
    }
    @Test
    void getRandomName(){

    }
    @Test
    void getRandomSurName(){

    }
    @Test
    void getRandomRole(){

    }
    @Test
    void getRandomStreet(){

    }


}
