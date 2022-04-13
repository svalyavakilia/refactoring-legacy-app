package legacyapp.user.validation;

public interface Validator<T> {
    boolean validate(final T toValidate);
}