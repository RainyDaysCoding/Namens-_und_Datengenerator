import java.time.LocalDate;
import java.time.Period;

public class CompanyWorker {
    String surname;
    String name;
    String role;
    String country;
    String city;
    String street;
    LocalDate birthDate;
    String houseNumber;
    int salary;
    int zipCode;

    public CompanyWorker(String surname, String name, String role, String country, String city, String street, LocalDate birthDate, String houseNumber, int salary, int zipCode) {
        this.surname = surname;
        this.name = name;
        this.role = role;
        this.country = country;
        this.city = city;
        this.street = street;
        this.birthDate = birthDate;
        this.houseNumber = houseNumber;
        this.salary = salary;
        this.zipCode = zipCode;
    }

    public int calculateAge() {
        return Period.between(LocalDate.now(), this.birthDate).getYears();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

}
