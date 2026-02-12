package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import Backend.CompanyWorker;

public class CompanyWorkerTest {

    @Test
    public void calculateAge() {
        // Arrange
        LocalDate date = LocalDate.of(2000, 1, 1);
        CompanyWorker companyWorker = new CompanyWorker(
                "TestSur",
                "TestName",
                "TestRoll",
                "TestCountry",
                "TestCity",
                "TestStreet",
                date,
                "30",
                3000,
                10001);

        int result = companyWorker.calculateAge();

        assertEquals(result, 26, "Fehler: Alter ist Falsch");

    }

}
