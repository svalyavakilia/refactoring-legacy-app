package legacyapp.user.service;

import java.time.LocalDate;
import legacyapp.client.model.Client;
import legacyapp.client.repository.ClientRepository;
import legacyapp.client.repository.ClientRepositoryImpl;
import legacyapp.user.dao.UserDataAccess;
import legacyapp.user.model.User;
import legacyapp.user.validation.EmailValidator;
import legacyapp.user.validation.FirstNameValidator;
import legacyapp.user.validation.LastNameValidator;
import legacyapp.user.validation.Validator;

public record UserService(Validator<String> emailValidator,
                          Validator<String> firstNameValidator,
                          Validator<String> lastNameValidator,
                          ClientRepository clientRepository,
                          UserCreditService userCreditService) {
    /* can be implemented with the dependency injection */
    public UserService() {
        this(
            new EmailValidator(),
            new FirstNameValidator(),
            new LastNameValidator(),
            new ClientRepositoryImpl(),
            new UserCreditServiceImpl()
        );
    }

    public boolean addUser(final String firstName,
                           final String lastName,
                           final String email,
                           final LocalDate dateOfBirth,
                           final int clientId) {
        if ((!firstNameValidator.validate(firstName))
             ||
            (!lastNameValidator.validate(lastName))
             ||
            (!emailValidator.validate(email))
             ||
            (User.calculateAge(dateOfBirth) < 21)) return false;

        final Client client = clientRepository.getClientById(clientId);
        final User user = new User(
            client, dateOfBirth, email, firstName, lastName, null, null
        );

        try {
            client.setCreditLimitForAUser(user, userCreditService);
        } catch (final Exception e) {
            return false;
        }

        if (user.hasCreditLimit() && (user.getCreditLimit() < 500)) {
            return false;
        }

        UserDataAccess.addUser(user);

        return true;
    }
}