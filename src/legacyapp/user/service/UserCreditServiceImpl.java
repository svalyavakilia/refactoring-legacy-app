package legacyapp.user.service;

import java.time.LocalDate;

public class UserCreditServiceImpl implements UserCreditService {
    @Override
    public void close() {}

    @Override
    public int getCreditLimit(final String firstName,
                              final String lastName,
                              final LocalDate dateOfBirth) {
        /* getting the data... */

        return 10000;
    }
}