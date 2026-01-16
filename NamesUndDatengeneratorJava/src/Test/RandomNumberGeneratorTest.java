package Test;
import Java.RandomNumberGenerator;

import org.;

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

    void generateZipCode(){
        //Arrang
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        //Action
        int result =

        //Assert
        assertTrue(result < 21 && result > 9, "Fehler: Zahl liegt nicht zwischen 10 und 20");

    }

    void generatesBirthdate(){

    }

    void generateSalary(){

    }

    void generateHouseNumber(){

    }

    void getRandomName(){

    }

    void getRandomSurName(){

    }

    void getRandomRole(){

    }

    void getRandomStreet(){

    }


}
