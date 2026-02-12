package Backend;
import java.util.ArrayList;

public class CountryData {
    
    String country;
    ArrayList<String> surNames;
    ArrayList<String> names;
    ArrayList<String> roles;
    ArrayList<String> cities;
    ArrayList<String> streets;
    
    public CountryData(String country, ArrayList<String> surNames, ArrayList<String> names, ArrayList<String> roles, ArrayList<String> cities, ArrayList<String> streets) {
        this.country = country;
        this.surNames = surNames;
        this.names = names;
        this.roles = roles;
        this.cities = cities;
        this.streets = streets;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getSurNames() {
        return surNames;
    }

    public void setSurNames(ArrayList<String> surNames) {
        this.surNames = surNames;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void setCities(ArrayList<String> cities) {
        this.cities = cities;
    }

    public ArrayList<String> getStreets() {
        return streets;
    }

    public void setStreets(ArrayList<String> streets) {
        this.streets = streets;
    }

    public int getNamesLength() {
        return names.size(); 
    }

    public int getSurnamesLength() {
        return surNames.size(); 
    }

    public int getRoleLength() {
        return roles.size(); 
    }

    public int getStreetLength() {
        return streets.size(); 
    }

    public int getCitiesLength() {
        return cities.size(); 
    }
}
