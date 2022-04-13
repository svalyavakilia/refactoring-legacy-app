package legacyapp.user.model;

import java.time.Period;
import java.time.LocalDate;
import legacyapp.client.model.Client;

public class User {
    private final Client client;
    private final LocalDate dateOfBirth;
    private final String emailAddress;
    private final String firstName;
    private final String lastName;
    private Boolean hasCreditLimit;
    private Integer creditLimit;

    public User(final Client client,
                final LocalDate dateOfBirth,
                final String emailAddress,
                final String firstName,
                final String lastName,
                final Boolean hasCreditLimit,
                final Integer creditLimit) {
        this.client = client;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasCreditLimit = hasCreditLimit;
        this.creditLimit = creditLimit;
    }

    public static int calculateAge(final LocalDate dateOfBirth) {
        return Period.between(
                dateOfBirth, LocalDate.now().plusDays(1)
        ).getYears();
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean hasCreditLimit() {
        return hasCreditLimit;
    }

    public void hasCreditLimit(boolean hasCreditLimit) {
        this.hasCreditLimit = hasCreditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}