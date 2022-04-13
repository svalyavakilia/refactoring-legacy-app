package legacyapp.client.model;

import legacyapp.client.enumeration.ClientName;
import legacyapp.user.model.User;
import legacyapp.user.service.UserCreditService;

import static legacyapp.client.enumeration.ClientName.IMPORTANT_CLIENT;
import static legacyapp.client.enumeration.ClientName.VERY_IMPORTANT_CLIENT;

public record Client(ClientName name, int clientId) {
    public void
    setCreditLimitForAUser(final User user,
                           final UserCreditService userCreditService)
                                                            throws Exception {
        if (VERY_IMPORTANT_CLIENT.equals(this.name())) {
            user.hasCreditLimit(false);
        } else if (IMPORTANT_CLIENT.equals(this.name())) {
            try (userCreditService) {
                int creditLimit = userCreditService.getCreditLimit(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getDateOfBirth()
                );

                creditLimit *= 2;

                user.setCreditLimit(creditLimit);
            }
        } else {
            user.hasCreditLimit(true);

            try (userCreditService) {
                int creditLimit = userCreditService.getCreditLimit(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getDateOfBirth()
                );

                user.setCreditLimit(creditLimit);
            }
        }
    }
}