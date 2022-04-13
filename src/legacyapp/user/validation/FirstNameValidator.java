package legacyapp.user.validation;

public class FirstNameValidator implements Validator<String> {
    @Override
    public boolean validate(final String firstName) {
        return !(firstName == null) && !(firstName.isBlank());
    }
}