package Java;
import java.util.Random;
import java.time.LocalDate;

public class RandomNumberGenerator {
    
    Random rand;

    public RandomNumberGenerator() {
       this.rand = new Random();
    }

    public int generateRandomINTInRage(int min,int max){
        return rand.nextInt((max - min) + 1) + min;
    }

    public int generateZipCode(){
        
        return generateRandomINTInRage(10000,99999);
    }

    public String generatesBirthdate(){
        int day,month,year;
        String result;
        //Generiert ein jahr Monat und Tag
        year = generateRandomINTInRage(LocalDate.now().getYear()-70,LocalDate.now().getYear()-16);
        month = generateRandomINTInRage(1, 12);
        if(month == 2){
            day = generateRandomINTInRage(1, 28);
        }else if( month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            day = generateRandomINTInRage(1, 31);
        }else{
            day = generateRandomINTInRage(1, 30);
        }

        // Wandelt die zahlen in strings um und ins normale Datums format
        if(day <= 9){
            result = "0" + Integer.toString(day);
        }else{
            result = Integer.toString(day);
        }

        if(month <= 9){
            result = result + ".0" + Integer.toString(month);
        }else{
            result = result + "." + Integer.toString(month);
        }

        result = result + "." + Integer.toString(year);

        return result;

    }

    public String generateSalary(){
        return String.valueOf(generateRandomINTInRage(1500, 10000));
    }

    public String generateHouseNumber(){
        int temp = 0, number;
        String[] letter = {"","A","B","C","D"};

        if(generateRandomINTInRage(1, 2) % 2 == 0){
            temp = generateRandomINTInRage(0, 4);
        }

        number = generateRandomINTInRage(1, 100);

        return Integer.toString(number) + " "+ letter[temp];
    }

    public String getRandomName(CountryData countryData){
        return countryData.getNames().get(generateRandomINTInRage(0, countryData.getNamesLength()));
    }

    public String getRandomSurName(CountryData countryData){
        return countryData.getNames().get(generateRandomINTInRage(0, countryData.getSurnamesLength()));
    }

    public String getRandomRole(CountryData countryData){
        return countryData.getNames().get(generateRandomINTInRage(0, countryData.getRoleLength()));
    }

    public String getRandomStreet(CountryData countryData){
        return countryData.getNames().get(generateRandomINTInRage(0, countryData.getStreetLength()));
    }

    public String getRandomCity(CountryData countryData){
        return countryData.getCities().get(generateRandomINTInRage(0, countryData.getCitiesLength()));
    }
}
