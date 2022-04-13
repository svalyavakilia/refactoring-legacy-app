package legacyapp.user.validation;

public class EmailValidator implements Validator<String> {
    @Override
    public boolean validate(final String email) {
        return !(email == null) && email.contains("@") && email.contains(".");
    }
}