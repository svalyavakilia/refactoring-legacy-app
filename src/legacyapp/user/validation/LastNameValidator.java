package legacyapp.user.validation;

public class LastNameValidator implements Validator<String> {
    @Override
    public boolean validate(final String lastName) {
        return !(lastName == null) && !(lastName.isBlank());
    }
}