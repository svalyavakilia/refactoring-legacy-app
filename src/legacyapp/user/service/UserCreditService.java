package legacyapp.user.service;

import java.time.LocalDate;

public interface UserCreditService extends AutoCloseable {
    int getCreditLimit(final String firstName,
                       final String lastName,
                       final LocalDate dateOfBirth);
}